public enum Roman_numerals {
    I("1"),
    II("2"),
    III("3"),
    IV("4"),
    V("5"),
    VI("6"),
    VII("7"),
    VIII("8"),
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
