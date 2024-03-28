package com.shinsegae.ssgdx.rst.util;

import java.sql.Blob;
import java.sql.Clob;

public class LOBConvert {

    public static byte[] BlobToByteArrayConvert(Blob blob){
        int blobLength = 0;
        byte[] blobAsBytes = {};

        try{
            blobLength = (int)blob.length();
            blobAsBytes = blob.getBytes(1, blobLength);
        }catch(Exception e){
            e.printStackTrace();
        }

        return blobAsBytes;
    }

    public static String ClobToStringConvert(Clob clob){
        int clobLength = 0;
        String clobString = "";

        try{
            clobLength = (int)clob.length();
            clobString = clob.getSubString(1, clobLength);
        }catch(Exception e){
            e.printStackTrace();
        }

        return clobString;
    }
}
