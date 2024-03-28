package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemHeader {

    @IIrtFldMeta(size = 2)
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    private String ItemLength; // ITEM길이

    private int ItemLengthNum;

    public int getItemLengthNum(){
        this.ItemLengthNum = 0;

        try{
            if(ItemLength != null){
                this.ItemLengthNum = Integer.valueOf(ItemLength);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return this.ItemLengthNum;
    }
}
