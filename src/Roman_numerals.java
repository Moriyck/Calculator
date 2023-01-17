public enum Roman_numerals {
    I("1"),
    III("3"),
    IV("4"),
    V("5"),
    IX("9"),
    X("10");
    
    String displayRomNum;
    String arabNumString = "I";

    Roman_numerals(String displayRomNum) {
        this.displayRomNum = displayRomNum;
    }

    String setRomNum(String arabNumString) {

        switch (arabNumString) {
            case "I":
                displayRomNum = "1";
        }
        return displayRomNum;
    }

    String getRomNum() {
        return displayRomNum;
    }
}
