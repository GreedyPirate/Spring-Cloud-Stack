package com.ttyc.lombok;

import lombok.NonNull;

public class NoNullCheck {
    public static void main(String[] args) {
        @NonNull NoNullCheck nullCheck = null;
        nullCheck.toString();
    }
}
