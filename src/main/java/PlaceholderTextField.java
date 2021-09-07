public class PlaceholderTextField {
    public static void main(String[] args) {
        String WhatType="keyboard";
        String foundTyp= switch (WhatType){
            case "keyboard"->"ic_keyboard_16.png";
            case "link"-> "ic_link_16.png";
            default -> "ic_unknown_16.png";
        };
        System.out.println(foundTyp);
    }
}