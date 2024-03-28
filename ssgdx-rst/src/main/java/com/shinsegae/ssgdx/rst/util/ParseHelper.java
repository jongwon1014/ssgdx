package com.shinsegae.ssgdx.rst.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.shinsegae.ssgdx.ldi.model.comirt.EncHeader;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt;
import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;
import com.shinsegae.ssgdx.rst.model.comtr.ComHeader;
import com.shinsegae.ssgdx.rst.model.comtr.ItemHeader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParseHelper {

    /**
     * 주어진 객체의 멤버들의 전체 길이를 구한다
     * 
     * @param <T> : 객체 타입
     * @param tgObj : 객체 이름
     * @return
     */
    public static <T> int tranTotalSize(T tgObj){
        int nTranTotSize = 0;

        if(tgObj != null){
            try{
                for(Field field : tgObj.getClass().getDeclaredFields()){
                    IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
                    if(irtFldMeta != null){
                        // 제너릭의 파라미터는 1개만 존재해야 한다!!
                        if("list".equals(irtFldMeta.dType().getType())){
                            Type type = field.getGenericType();
                            if(type instanceof ParameterizedType){
                                Type[] inType = ((ParameterizedType)type).getActualTypeArguments();
                                if(inType.length > 1){
                                    log.error("func:tranTotalSize -- {}",
                                            "[ERROR] Collection parameter는 하나만 존재해야 한다!!");
                                    return 0;
                                }
                                nTranTotSize = nTranTotSize + tranTotalSize(Class.forName(inType[0].getTypeName()));
                            }
                        }else if("class".equals(irtFldMeta.dType().getType())){
                            nTranTotSize = nTranTotSize + tranTotalSize(Class.forName(field.getType().getName()));
                        }else{
                            nTranTotSize += irtFldMeta.size();
                        }
                    }
                }
                log.debug("func:tranTotalSize -- Obj:{} -- totalSize:{}", tgObj.getClass().getName(), nTranTotSize);
            }catch(Exception e){
                // TODO Auto-generated catch block
                log.error(e.toString());
            }
        }else{
            log.error("func:tranTotalSize -- {}", "[ERROR] object is null!!");
        }

        return nTranTotSize;
    }

    /**
     * 주어진 클래스의 멤버들의 전체 길이를 구한다
     * 
     * @param <T> : 객체 타입
     * @param tgObj : 객체 이름
     * @return
     */
    public static <T> int tranTotalSize(Class<?> clazz){
        int nTranTotSize = 0;

        if(clazz != null){
            try{
                for(Field field : clazz.getDeclaredFields()){
                    IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
                    if(irtFldMeta != null){
                        // 제너릭의 파라미터는 1개만 존재해야 한다!!
                        if("list".equals(irtFldMeta.dType().getType())){
                            Type type = field.getGenericType();
                            if(type instanceof ParameterizedType){
                                Type[] inType = ((ParameterizedType)type).getActualTypeArguments();
                                if(inType.length > 1){
                                    log.error("func:tranTotalSize -- {}",
                                            "[ERROR] Collection parameter는 하나만 존재해야 한다!!");
                                    return 0;
                                }
                                nTranTotSize = nTranTotSize + tranTotalSize(Class.forName(inType[0].getTypeName()));
                            }
                        }else if("class".equals(irtFldMeta.dType().getType())){
                            nTranTotSize = nTranTotSize + tranTotalSize(Class.forName(field.getType().getName()));
                        }else{
                            nTranTotSize += irtFldMeta.size();
                        }
                    }
                }
                log.debug("func:tranTotalSize -- Obj:{} -- totalSize:{}", clazz.getName(), nTranTotSize);
            }catch(Exception e){
                // TODO Auto-generated catch block
                log.error(e.toString());
            }
        }else{
            log.error("func:tranTotalSize -- {}", "[ERROR] object is null!!");
        }

        return nTranTotSize;
    }

    /**
     * 바이트배열과 오프셋, 결과를 담을 객체를 인수로 받아서 전문을 파싱한다
     * 
     * @param <T> : 객체 타입
     * @param tranBytes : 거래 전문 전체(바이트 배열)
     * @param offSet : 전문 파싱 offest
     * @param tgObj : 전문 파싱 대상 객체
     * @param itemLen : 아이템 헤더의 아이템 길이 (루프가 아닐경우 값이 있으면 전문 길이 체크, 하위 반복횟수
     * 구할때 사용)
     * @param exLoopLen : 루프가 포함되어 있을경우 루프를 제외한 전문 길이
     * @param restoreOffsetFg : 전문 파싱 후 offset을 파싱 전으로 되돌림 (아이템 헤더를 먼저 한번 읽을때
     * 사용)
     * @param isLoop : 전문에 루프(Array)가 있을 경우 true (반복구문은 1개만 있다고 가정)
     * @return
     */
    public static <T> int tranMapToObj(byte[] tranBytes, int[] offSet, T tgObj, int itemLen, int exLoopLen,
            boolean restoreOffsetFg, boolean isLoop){
        int ret = -1;

        if(tgObj != null){
            StringBuffer sb = new StringBuffer();
            try{
                // 대상 객체 멤버들의 전체 길이
                int nTranTotSize = tranTotalSize(tgObj);

                if(!isLoop && itemLen > 0 && itemLen != nTranTotSize){
                    log.error("func:tranMapToObj -- [ERROR] itemLen({}) != nTranTotSize({})!!", itemLen, nTranTotSize);
                    return ret;
                }
                sb.append("\n");
                sb.append("func:tranMapToObj -- Obj:" + tgObj.getClass().getName() + " -- offset:" + offSet[0]
                        + " -- start\n");

                ret = 0;
                boolean bItemHeader = false; // 아이템 헤더 유무
                boolean bpreLoopCount = false; // 반복 횟수 유무
                int preLoopCount = 0;

                // 대상 객체의 멤버 조회
                for(Field field : tgObj.getClass().getDeclaredFields()){
                    // 어노테이션 선언 멤버만 대상으로 본다
                    IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
                    if(irtFldMeta != null){
                        // 멤버 접근 설정
                        field.setAccessible(true);

                        // 멤버가 클래스이고 아이템 헤더를 가지고 있는지 설정
                        if(irtFldMeta.isItemHeader())
                            bItemHeader = true;

                        // field 타입이 제너릭 배열이면 제너릭 타입의 클래스(inner) 멤버 값 세팅
                        // 리스트일 경우 제너릭 클래스 파싱
                        if("list".equals(irtFldMeta.dType().getType())){
                            if(bpreLoopCount){
                                ret = makeListDataWithLoopCount(tranBytes, offSet, tgObj, preLoopCount, sb, field,
                                        irtFldMeta);
                                bpreLoopCount = false;
                                preLoopCount = 0;
                            }else
                                ret = makeListDataWithLength(tranBytes, offSet, tgObj, itemLen, exLoopLen, bItemHeader,
                                        sb, field, irtFldMeta);

                            if(ret != 0)
                                break;
                        }
                        // 클래스 멤버일 경우 클래스 파싱
                        else if("class".equals(irtFldMeta.dType().getType())){
                            ret = makeClassData(tranBytes, offSet, tgObj, bItemHeader, sb, field, irtFldMeta);
                            if(ret != 0)
                                break;
                        }
                        // 기본타입 멤버일 경우 파싱
                        else{
                            String fv = "";
                            int size = irtFldMeta.size();
                            if(size > 0){
                                byte[] b = new byte[size];
                                System.arraycopy(tranBytes, offSet[0], b, 0, size);
                                fv = new String(b, StandardCharsets.UTF_8);
                                field.set(tgObj, fv);
                                offSet[0] += size;

                                // 반복 횟수 저장
                                if(irtFldMeta.isLoopCount()){
                                    bpreLoopCount = true;
                                    preLoopCount = Integer.valueOf(fv);
                                }
                            }
                            sb.append(String.format("fn:%-30s -- fs:%-8d -- fv:[%s]\n", field.getName(),
                                    irtFldMeta.size(), fv));
                        }

                        bItemHeader = false;
                    }
                }

                if(ret == 0){
                    sb.append("func:tranMapToObj -- Obj:" + tgObj.getClass().getName() + " -- offset:" + offSet[0]
                            + " -- end");
                    if(restoreOffsetFg){
                        offSet[0] -= itemLen;
                        sb.append("func:tranMapToObj -- Obj:" + tgObj.getClass().getName() + " -- restoreOffset:"
                                + offSet[0] + " -- end");
                    }
                }else{
                    log.error("func:tranMapToObj -- {}", "[ERROR] parsing error!!");
                }

                // DEBUG TEST (debug로 전환 필요)
                log.info(sb.toString());
            }catch(Exception e){
                // TODO Auto-generated catch block
                log.error(e.toString());
                ret = -1;
            }
        }else{
            log.error("func:tranMapToObj -- {}", "[ERROR] object is null!!");
        }

        return ret;
    }

    /**
     * @param <T>
     * @param tranBytes : 거래 전문 전체(bytes)
     * @param offSet : 전문 파싱 offest
     * @param tgObj : 전문 파싱 대상 객체
     * @param loopCount : 반복횟수
     * @param sb : 로그용 StringBuffer
     * @param field : 대상 필드
     * @param irtFldMeta : 대상 필드의 어노테이션
     * @return
     * @throws Exception
     */
    public static <T> int makeListDataWithLoopCount(byte[] tranBytes, int[] offSet, T tgObj, int loopCount,
            StringBuffer sb, Field field, IIrtFldMeta irtFldMeta) throws Exception{
        int ret = -1;
        Type type = field.getGenericType();
        if(type instanceof ParameterizedType){
            Type[] inType = ((ParameterizedType)type).getActualTypeArguments();
            if(inType.length > 1){
                log.error("func:makeListData -- {}", "[ERROR] Collection parameter는 하나만 존재해야 한다!!");
                return ret;
            }

            // ArrayList 제너릭 타입 생성
            Class<?> clazz = Class.forName(inType[0].getTypeName());

            ret = 0;
            for(int i = 0; i < loopCount; i++){
                String typeName = clazz.getName();
                Object inObj = null;

                // 사용자 정의 클래스일때만 매핑
                if(typeName != null && typeName.contains("com.shinsegae.ssgdx.rst")){
                    // 내부 클래스 체크해서 내부 클래스용 인스턴스 생성
                    if(typeName.contains("$")){
                        Class<?> innerClass = Class.forName(typeName);

                        // inner class를 static으로 변경해서 수정 함
                        if(Modifier.isStatic(innerClass.getModifiers())){
                            Constructor<?> ctor = innerClass.getDeclaredConstructor();
                            ctor.setAccessible(true);
                            inObj = ctor.newInstance();
                        }else{
                            Constructor<?> ctor = innerClass.getDeclaredConstructor(tgObj.getClass());
                            ctor.setAccessible(true);
                            inObj = ctor.newInstance(tgObj);
                        }
                    }
                    // 외부 클래스용 인스턴스 생성
                    else{
                        inObj = clazz.getDeclaredConstructor().newInstance();
                    }

                    sb.append(String.format("[%s (tot:%2d, idx:%2d)]\n", inObj.getClass().getSimpleName(), loopCount,
                            i + 1));
                    for(Field inField : clazz.getDeclaredFields()){
                        IIrtFldMeta inIIrtFldMeta = inField.getAnnotation(IIrtFldMeta.class);
                        if(inIIrtFldMeta != null){
                            inField.setAccessible(true);
                            int size = inIIrtFldMeta.size();
                            String fv = "";
                            if(size > 0){
                                byte[] b = new byte[size];
                                System.arraycopy(tranBytes, offSet[0], b, 0, size);
                                fv = new String(b, StandardCharsets.UTF_8);
                                inField.set(inObj, fv);
                                offSet[0] += size;
                            }
                            sb.append(String.format("fn:%-30s -- fs:%-8d -- fv:[%s]\n", inField.getName(),
                                    inIIrtFldMeta.size(), fv));
                        }
                    }
                    // add ArrayList
                    @SuppressWarnings("unchecked")
                    ArrayList<Object> actualList = (ArrayList<Object>)field.get(tgObj);
                    actualList.add(inObj);
                    field.set(tgObj, actualList);

                }
            }
        }else{
            log.error("func:makeListData -- {}", "[ERROR] type instanceof ParameterizedType) error!!");
        }

        return ret;
    }

    /**
     * 대상 객체가 리스트일 경우 파싱
     * 
     * @param <T>
     * @param tranBytes : 거래 전문 전체(bytes)
     * @param offSet : 전문 파싱 offest
     * @param tgObj : 전문 파싱 대상 객체
     * @param itemLen : 아이템 헤더의 아이템 길이 (루프가 아닐경우 값이 있으면 전문 길이 체크, 하위 반복횟수 구할때
     * 사용)
     * @param exLoopLen : 루프가 포함되어 있을경우 루프를 제외한 전문 길이
     * @param sb : 로그용 StringBuffer
     * @param field : 대상 필드
     * @param irtFldMeta : 대상 필드의 어노테이션
     * @return
     * @throws Exception
     */
    public static <T> int makeListDataWithLength(byte[] tranBytes, int[] offSet, T tgObj, int itemLen, int exLoopLen,
            boolean bItemHeader, StringBuffer sb, Field field, IIrtFldMeta irtFldMeta) throws Exception{
        int ret = -1;
        Type type = field.getGenericType();
        if(type instanceof ParameterizedType){
            Type[] inType = ((ParameterizedType)type).getActualTypeArguments();
            if(inType.length > 1){
                log.error("func:makeListData -- {}", "[ERROR] Collection parameter는 하나만 존재해야 한다!!");
                return ret;
            }

            // ArrayList 제너릭 타입 생성
            Class<?> clazz = Class.forName(inType[0].getTypeName());

            // 반복횟수 계산
            int inTranTotSize = 0, inLoopCnt = 0, excludeRepeatLength = 0;
            inTranTotSize = tranTotalSize(clazz);
            if(bItemHeader){
                ItemHeader itemHeader = new ItemHeader();
                ret = ParseHelper.tranMapToObj(tranBytes, offSet, itemHeader, IEnumComIrt.DEF_ITEM_HD_LEN, 0, true,
                        false);
                if(ret != 0)
                    return ret;
                excludeRepeatLength = getExcludeRepeatLength(field);
                inLoopCnt = (itemHeader.getItemLengthNum() - excludeRepeatLength) / inTranTotSize;
            }else{
                inLoopCnt = (itemLen - exLoopLen) / inTranTotSize;
            }

            ret = 0;
            for(int i = 0; i < inLoopCnt; i++){
                String typeName = clazz.getName();
                Object inObj = null;

                // 사용자 정의 클래스일때만 매핑
                if(typeName != null && typeName.contains("com.shinsegae.ssgdx.rst")){
                    // 내부 클래스 체크해서 내부 클래스용 인스턴스 생성
                    if(typeName.contains("$")){
                        Class<?> innerClass = Class.forName(typeName);

                        // inner class를 static으로 변경해서 수정 함
                        if(Modifier.isStatic(innerClass.getModifiers())){
                            Constructor<?> ctor = innerClass.getDeclaredConstructor();
                            ctor.setAccessible(true);
                            inObj = ctor.newInstance();
                        }else{
                            Constructor<?> ctor = innerClass.getDeclaredConstructor(tgObj.getClass());
                            ctor.setAccessible(true);
                            inObj = ctor.newInstance(tgObj);
                        }
                    }
                    // 외부 클래스용 인스턴스 생성
                    else{
                        inObj = clazz.getDeclaredConstructor().newInstance();
                    }

                    sb.append(String.format("[%s (tot:%2d, idx:%2d)]\n", inObj.getClass().getSimpleName(), inLoopCnt,
                            i + 1));
                    for(Field inField : clazz.getDeclaredFields()){
                        IIrtFldMeta inIIrtFldMeta = inField.getAnnotation(IIrtFldMeta.class);
                        if(inIIrtFldMeta != null){
                            inField.setAccessible(true);
                            int size = inIIrtFldMeta.size();
                            String fv = "";
                            if(size > 0){
                                byte[] b = new byte[size];
                                System.arraycopy(tranBytes, offSet[0], b, 0, size);
                                fv = new String(b, StandardCharsets.UTF_8);
                                inField.set(inObj, fv);
                                offSet[0] += size;
                            }
                            sb.append(String.format("fn:%-30s -- fs:%-8d -- fv:[%s]\n", inField.getName(),
                                    inIIrtFldMeta.size(), fv));
                        }
                    }
                    // add ArrayList
                    @SuppressWarnings("unchecked")
                    ArrayList<Object> actualList = (ArrayList<Object>)field.get(tgObj);
                    actualList.add(inObj);
                    field.set(tgObj, actualList);
                }
            }
        }else{
            log.error("func:makeListData -- {}", "[ERROR] type instanceof ParameterizedType) error!!");
        }

        return ret;
    }

    /**
     * 대상 객체가 클래스일 경우 파싱
     * 
     * @param <T>
     * @param tranBytes : 거래 전문 전체(bytes)
     * @param offSet : 전문 파싱 offest
     * @param tgObj : 전문 파싱 대상 객체
     * @param itemLen : 아이템 헤더의 아이템 길이 (루프가 아닐경우 값이 있으면 전문 길이 체크, 하위 반복횟수 구할때
     * 사용)
     * @param exLoopLen : 루프가 포함되어 있을경우 루프를 제외한 전문 길이
     * @param sb : 로그용 StringBuffer
     * @param field : 대상 필드
     * @param irtFldMeta : 대상 필드의 어노테이션
     * @return
     * @throws Exception
     */
    public static <T> int makeClassData(byte[] tranBytes, int[] offSet, T tgObj, boolean bItemHeader, StringBuffer sb,
            Field field, IIrtFldMeta irtFldMeta) throws Exception{
        int ret = -1;
        Class<?> clazz = field.getType();
        String typeName = field.getType().getName();
        Object inObj = null;

        // 사용자 정의 클래스일때만 매핑
        if(typeName != null && typeName.contains("com.shinsegae.ssgdx.rst") && !clazz.isPrimitive()){
            // 내부 클래스 체크해서 내부 클래스용 인스턴스 생성
            if(typeName.contains("$")){
                Class<?> innerClass = Class.forName(typeName);

                // inner class를 static으로 변경해서 수정 함
                if(Modifier.isStatic(innerClass.getModifiers())){
                    Constructor<?> ctor = innerClass.getDeclaredConstructor();
                    ctor.setAccessible(true);
                    inObj = ctor.newInstance();
                }else{
                    Constructor<?> ctor = innerClass.getDeclaredConstructor(tgObj.getClass());
                    ctor.setAccessible(true);
                    inObj = ctor.newInstance(tgObj);
                }
            }
            // 외부 클래스용 인스턴스 생성
            else{
                inObj = clazz.getDeclaredConstructor().newInstance();
            }

            sb.append(String.format("[%s]\n", inObj.getClass().getSimpleName()));

            int itemLen = 0, exLoopLen = 0;
            if(bItemHeader){
                ItemHeader itemHeader = new ItemHeader();
                ret = ParseHelper.tranMapToObj(tranBytes, offSet, itemHeader, IEnumComIrt.DEF_ITEM_HD_LEN, 0, true,
                        false);
                if(ret != 0)
                    return ret;
                itemLen = itemHeader.getItemLengthNum();
                exLoopLen = getExcludeRepeatLength(field);
            }

            boolean binItemHeader = false;
            boolean bpreLoopCount = false;
            int preLoopCount = 0;
            ret = 0;
            for(Field inField : clazz.getDeclaredFields()){
                IIrtFldMeta inIIrtFldMeta = inField.getAnnotation(IIrtFldMeta.class);
                if(inIIrtFldMeta != null){
                    inField.setAccessible(true);

                    if(inIIrtFldMeta.isItemHeader())
                        binItemHeader = true;

                    // field 타입이 제너릭 배열이면 제너릭 타입의 클래스 멤버 값 세팅
                    if("list".equals(inIIrtFldMeta.dType().getType())){
                        if(bpreLoopCount){
                            ret = makeListDataWithLoopCount(tranBytes, offSet, inObj, preLoopCount, sb, inField,
                                    inIIrtFldMeta);
                            bpreLoopCount = false;
                            preLoopCount = 0;
                        }else
                            ret = makeListDataWithLength(tranBytes, offSet, inObj, itemLen, exLoopLen, binItemHeader,
                                    sb, inField, inIIrtFldMeta);

                        if(ret != 0)
                            break;
                    }else if("class".equals(inIIrtFldMeta.dType().getType())){
                        ret = makeClassData(tranBytes, offSet, inObj, binItemHeader, sb, inField, inIIrtFldMeta);
                        if(ret != 0)
                            break;
                    }else{
                        String fv = "";
                        int size = inIIrtFldMeta.size();
                        if(size > 0){
                            byte[] b = new byte[size];
                            System.arraycopy(tranBytes, offSet[0], b, 0, size);
                            fv = new String(b, StandardCharsets.UTF_8);
                            inField.set(inObj, fv);
                            offSet[0] += size;

                            // 반복 횟수 저장
                            if(inIIrtFldMeta.isLoopCount()){
                                bpreLoopCount = true;
                                preLoopCount = Integer.valueOf(fv);
                            }
                        }
                        sb.append(String.format("fn:%-30s -- fs:%-8d -- fv:[%s]\n", inField.getName(),
                                inIIrtFldMeta.size(), fv));
                    }

                    binItemHeader = false;
                }
            }
            field.set(tgObj, inObj);
        }

        return ret;
    }

    /**
     * 대상 객체의 멤버들의 전체 길이 계산 (단, 반복 리스트 멤버 제외)
     * 
     * @param <T>
     * @param tranBytes :
     * @param offSet :
     * @param field :
     * @param irtFldMeta :
     * @return
     * @throws Exception
     */
    public static <T> int getExcludeRepeatLength(Field field) throws Exception{
        int ret = 0;

        Class<?> clazz = field.getType();

        for(Field inField : clazz.getDeclaredFields()){
            IIrtFldMeta inIIrtFldMeta = inField.getAnnotation(IIrtFldMeta.class);
            if(inIIrtFldMeta != null){
                inField.setAccessible(true);
                if(!"list".equals(inIIrtFldMeta.dType().getType())){
                    if("class".equals(inIIrtFldMeta.dType().getType())){
                        for(Field iinField : Class.forName(inField.getType().getName()).getDeclaredFields()){
                            IIrtFldMeta iinIIrtFldMeta = iinField.getAnnotation(IIrtFldMeta.class);
                            if(iinIIrtFldMeta != null){
                                iinField.setAccessible(true);
                                if(!"list".equals(iinIIrtFldMeta.dType().getType())){
                                    ret = ret + getExcludeRepeatLength(iinField);
                                }
                            }
                        }
                    }else
                        ret = ret + inIIrtFldMeta.size();
                }
            }
        }
        return ret;
    }

    /**
     * 주어진 대상 객체의 필드 길이를 구한다
     * 
     * @param <T>
     * @param tgObj : 전문 파싱 대상 객체
     * @param fieldName : 대상 필드 이름
     * @return
     * @throws Exception
     */
    public static <T> int getFieldSize(T tgObj, String fieldName) throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        return irtFldMeta.size();
    }

    /**
     * @param <T> : 대상 객체
     * @param tranBytes : 거래 전문 전체(bytes)
     * @param offSet : 전문 파싱 offest
     * @param tgObj : 전문 파싱 대상 객체
     * @param fieldName : 대상 필드 이름
     * @param itemLen : 아이템 헤더의 아이템 길이 (루프가 아닐경우 값이 있으면 전문 길이 체크, 하위 반복횟수 구할때
     * 사용)
     * @param exLoopLen : 루프가 포함되어 있을경우 루프를 제외한 전문 길이
     * @param loopCount : 반복횟수
     * @return
     * @throws Exception
     */
    public static <T> int setTranFieldData(byte[] tranBytes, int[] offSet, T tgObj, String fieldName, int itemLen,
            int exLoopLen, int loopCount) throws Exception{
        int ret = -1;
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        StringBuffer sb = new StringBuffer();
        boolean bItemHeader = false; // 아이템 헤더 유무

        if(irtFldMeta != null){
            // 멤버가 클래스이고 아이템 헤더를 가지고 있는지 설정
            if(irtFldMeta.isItemHeader())
                bItemHeader = true;

            // field 타입이 제너릭 배열이면 제너릭 타입의 클래스(inner) 멤버 값 세팅
            // 리스트일 경우 제너릭 클래스 파싱
            if("list".equals(irtFldMeta.dType().getType())){
                if(loopCount > 0)
                    ret = makeListDataWithLoopCount(tranBytes, offSet, tgObj, loopCount, sb, field, irtFldMeta);
                else
                    ret = makeListDataWithLength(tranBytes, offSet, tgObj, itemLen, exLoopLen, bItemHeader, sb, field,
                            irtFldMeta);
            }
            // 클래스 멤버일 경우 클래스 파싱
            else if("class".equals(irtFldMeta.dType().getType())){
                ret = makeClassData(tranBytes, offSet, tgObj, bItemHeader, sb, field, irtFldMeta);
            }
            // 기본타입 멤버일 경우 파싱
            else{
                String fv = "";
                int size = irtFldMeta.size();
                if(size > 0){
                    byte[] b = new byte[size];
                    System.arraycopy(tranBytes, offSet[0], b, 0, size);
                    fv = new String(b, StandardCharsets.UTF_8);
                    field.set(tgObj, fv);
                    offSet[0] += size;

                    ret = 0;
                }
                sb.append(String.format("fn:%-30s -- fs:%-8d -- fv:[%s]\n", field.getName(), irtFldMeta.size(), fv));
            }
        }

        if(ret == 0){
            sb.append("func:getTranFieldData -- Obj:" + tgObj.getClass().getName() + " -- offset:" + offSet[0]
                    + " -- end");
        }else{
            log.error("func:getTranFieldData -- {}", "[ERROR] parsing error!!");
        }
        log.debug(sb.toString());

        return ret;
    }

    /**
     * 문자열 LPAD (' ')
     * 
     * @param <T>
     * @param tgObj : 전문 파싱 대상 객체
     * @param fieldName : 대상 필드 이름
     * @param o_str : 패딩할 필드 값
     * @return
     * @throws Exception
     */
    public static <T> String getLpadFillSpaceStringForNewTran(T tgObj, String fieldName, String o_str) throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        int size = irtFldMeta.size();
        if(o_str == null)
            o_str = "";

        // 신전문 사이즈가 구전문보다 작으면 스페이스로 채운다.
        if(size < o_str.length() || o_str.length() == 0)
            o_str = "";

        String sf = "%" + String.valueOf(size) + "s";
        return String.format(sf, o_str);
    }

    public static String getLpadFillSpaceString(String sTg, int size) throws Exception{
        if(sTg == null)
            sTg = "";

        // 신전문 사이즈가 구전문보다 작으면 스페이스로 채운다.
        if(size < sTg.length() || sTg.length() == 0)
            sTg = "";

        String sf = "%" + String.valueOf(size) + "s";
        return String.format(sf, sTg);
    }

    /**
     * 숫자 LPAD ('0')
     * 
     * @param <T>
     * @param tgObj : 전문 파싱 대상 객체
     * @param fieldName : 대상 필드 이름
     * @param o_str : 패딩할 필드 값
     * @return
     * @throws Exception
     */
    public static <T> String getLpadFillZeroStringForNewTran(T tgObj, String fieldName, String o_str) throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        int size = irtFldMeta.size();
        int o_val = 0;
        try{
            o_val = Integer.valueOf(o_str.trim());
        }catch(Exception e){
            // e.printStackTrace();
        }

        String sf = "%0" + String.valueOf(size) + "d";
        return String.format(sf, o_val);
    }

    public static <T> String getLpadFillZeroStringForNewTran(T tgObj, String fieldName, int o_val) throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        int size = irtFldMeta.size();

        String sf = "%0" + String.valueOf(size) + "d";
        return String.format(sf, o_val);
    }

    public static String getLpadFillZeroString(String sTg, int size) throws Exception{
        int nVal = 0;
        try{
            nVal = Integer.valueOf(sTg.trim());
        }catch(Exception e){
            // e.printStackTrace();
        }

        String sf = "%0" + String.valueOf(size) + "d";
        return String.format(sf, nVal);
    }

    public static String getLpadFillZeroString(int nTg, int size) throws Exception{
        int nVal = 0;
        try{
            nVal = nTg;
        }catch(Exception e){
            // e.printStackTrace();
        }

        String rVal = "";
        String sf = "";

        if(nTg < 0){
            nVal *= -1;
            if(size > 1){
                sf = "-%0" + String.valueOf(size - 1) + "d";
                rVal = String.format(sf, nVal);
            }
        }else{
            sf = "%0" + String.valueOf(size) + "d";
            rVal = String.format(sf, nVal);
        }

        return rVal;
    }

    /**
     * 문자열 RPAD (' ')
     * 
     * @param <T>
     * @param tgObj : 전문 파싱 대상 객체
     * @param fieldName : 대상 필드 이름
     * @param o_str : 패딩할 필드 값
     * @return
     * @throws Exception
     */
    public static <T> String getRpadFillSpaceStringForNewTran(T tgObj, String fieldName, String o_str) throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        int size = irtFldMeta.size();
        if(o_str == null)
            o_str = "";

        // 신전문 사이즈가 구전문보다 작으면 스페이스로 채운다.
        if(size < o_str.length() || o_str.length() == 0)
            o_str = "";

        String sf = "%-" + String.valueOf(size) + "s";
        return String.format(sf, o_str);
    }

    /**
     * 숫자 RPAD ('0')
     * 
     * @param <T>
     * @param tgObj : 전문 파싱 대상 객체
     * @param fieldName : 대상 필드 이름
     * @param o_str : 패딩할 필드 값
     * @return
     * @throws Exception
     */
    public static <T> String getRpadFillZeroStringForNewTran(T tgObj, String fieldName, String o_str) throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        int size = irtFldMeta.size();
        int o_val = 0;
        try{
            o_val = Integer.valueOf(o_str.trim());
        }catch(Exception e){
            // e.printStackTrace();
            o_str = "";
        }

        // 신전문 사이즈가 구전문보다 작으면 스페이스로 채운다.
        if(size < o_str.length() || o_str.length() == 0 || o_val == 0)
            o_str = "";

        return getRpadFillSpaceStringForNewTran(tgObj, fieldName, o_str).replace(" ", "0");
    }

    public static <T> String getRpadFillSpaceStringConvIntForTgFld(T tgObj, String fldName, String inStr)
            throws Exception{
        Field field = tgObj.getClass().getDeclaredField(fldName);
        field.setAccessible(true);
        IIrtFldMeta irtFldMeta = field.getAnnotation(IIrtFldMeta.class);
        int size = irtFldMeta.size();
        int o_val = convStrToInt(inStr);

        String sf = "%-" + String.valueOf(size) + "d";
        return String.format(sf, o_val);
    }

    public static String getRpadFillSpaceString(String sTg, int size) throws Exception{
        if(sTg == null)
            sTg = "";

        // 대상 필드의 사이즈가 입력 값 보다 작으면 스페이스로 채운다.
        if(size < sTg.length() || sTg.length() == 0)
            sTg = "";

        String sf = "%-" + String.valueOf(size) + "s";
        return String.format(sf, sTg);
    }

    public static String getRpadFillSpaceStringConvInt(String sTg, int size) throws Exception{
        int o_val = convStrToInt(sTg);

        String sf = "%-" + String.valueOf(size) + "d";
        return String.format(sf, o_val);
    }

    /**
     * <pre>
     * 주어진 문자를 int로 변환 (예외 발생시 0 반환)
     * </pre>
     *
     * @param sSrc
     * @return
     */
    public static int convStrToInt(String sSrc){
        int nVal = 0;
        try{
            nVal = Integer.valueOf(sSrc.trim());
        }catch(Exception e){
            // e.printStackTrace();
        }
        return nVal;
    }

    /**
     * <pre>
     * 주어진 숫자를 문자로 변환 (예외 발생시 "" 반환)
     * </pre>
     *
     * @param sSrc
     * @return
     */
    public static String convIntToStr(int nSrc){
        String sVal = "";
        try{
            sVal = Integer.toString(nSrc);
        }catch(Exception e){
            // e.printStackTrace();
        }
        return sVal;
    }

    /**
     * <pre>
     * 둘 이상의 바이트 어레이 연결
     * </pre>
     *
     * @param arrays
     * @return
     */
    public static byte[] byteArraysConcat(byte[]... arrays){
        byte[] result = null;
        int len = Arrays.stream(arrays).filter(Objects::nonNull).mapToInt(s -> s.length).sum();

        if(len > 0){
            result = new byte[len];
            int lengthSoFar = 0;

            if(arrays != null){
                for(byte[] array : arrays){
                    if(array != null){
                        System.arraycopy(array, 0, result, lengthSoFar, array.length);
                        lengthSoFar += array.length;
                    }
                }
            }
        }

        return result;
    }

    /**
     * <pre>
     * 통신 Header Copy
     * </pre>
     *
     * @param srcComHd
     * @param tgComHd
     */
    public static void copySrcComHdToTgComHd(ComHeader srcComHd, ComHeader tgComHd){
        // tgComHd.setMsgLength(srcComHd.getMsgLength());
        tgComHd.setMsgPath("MS"); // 매출수집 -> POS서버
        tgComHd.setMsgType(srcComHd.getMsgType());
        tgComHd.setMsgKind(srcComHd.getMsgKind());
        tgComHd.setSaleDate(srcComHd.getSaleDate());
        tgComHd.setStoreNo(srcComHd.getStoreNo());
        tgComHd.setPosNo(srcComHd.getPosNo());
        tgComHd.setTranNo(srcComHd.getTranNo());

        LocalDateTime now = LocalDateTime.now();
        tgComHd.setSendDate(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        tgComHd.setSendTime(now.format(DateTimeFormatter.ofPattern("HHmmss")));

        tgComHd.setExtStoreNo(srcComHd.getExtStoreNo());
        tgComHd.setTrainMode(srcComHd.getTrainMode());
        tgComHd.setVersionFlag(srcComHd.getVersionFlag());
        tgComHd.setUserInfo(srcComHd.getUserInfo());
        // tgComHd.setReplyCode(srcComHd.getReplyCode());
    }

    /**
     * <pre>
     * 암호화 헤더 생성
     * </pre>
     *
     * @param srcEncHd
     * @param tgEncHd
     * @param totLen
     * @param msgVli
     * @throws Exception
     */
    public static void makeEncHdFromComHd(ComHeader comHd, EncHeader encHd){
        encHd.setENCTYPE("B");
        encHd.setPOSNO(comHd.getPosNo());
        encHd.setTRANNO(comHd.getTranNo());
    }
}
