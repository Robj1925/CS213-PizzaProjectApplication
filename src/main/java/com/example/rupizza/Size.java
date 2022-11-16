package com.example.rupizza;

public class Size {
        private String SMALL = "small";
        private String MEDIUM = "medium";
        private String LARGE = "large";
        private String currentSize = "";

        public String getCurrentSize() {
                return this.currentSize;
        }
        public void setCurrentSize(String s) {
                this.currentSize = s;
        }


}
