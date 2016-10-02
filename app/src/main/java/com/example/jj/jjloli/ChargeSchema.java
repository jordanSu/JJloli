package com.example.jj.jjloli;

/**
 * Created by user on 2016/10/2.
 */

import java.util.Date;
import java.util.Locale;

public class ChargeSchema implements java.io.Serializable {
    
        private long id;
        private long datetime;
        private String common;
        private String chargetype;
        private long quantity;
        private int income;
     
        public ChargeSchema() {
            common = "";
            chargetype = "";
        }
     
        public ChargeSchema(long id, long datetime, String common,
                                    String chargetype, int income,
                                    long quantity) {
            this.id = id;
            this.datetime = datetime;
            this.common = common;
            this.chargetype = chargetype;
            this.income = income;
            this.quantity = quantity;
        }
 
        public long getId() {
            return id;
        }
 
        public void setId(long id) {
            this.id = id;
        }
 
        public long getDatetime() {
            return datetime;
        }
 
        // 裝置區域的日期時間
        public String getLocaleDatetime() {
            return String.format(Locale.getDefault(), "%tF  %<tR", new Date(datetime));
        }  
         
        // 裝置區域的日期
        public String getLocaleDate() {
            return String.format(Locale.getDefault(), "%tF", new Date(datetime));
        }
 
        // 裝置區域的時間
        public String getLocaleTime() {
            return String.format(Locale.getDefault(), "%tR", new Date(datetime));
        }  
         
        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }
 
            public String getCommon() {
            return common;
        }
 
            public void setCommon(String common) {
            this.common = common;
        }
 
            public String getChargetype() {
            return chargetype;
        }
 
            public void setChargetypet(String chargetype) {
            this.chargetype = chargetype;
        }
 
            public long getQuantity() {
            return quantity;
        }
 
            public void setQuantity(long quantity) {
            this.quantity = quantity;
        }
 
            public int getIncome() {
            return income;
        }
 
            public void setIncome(int income) {
            this.income = income;
        }
     
}
