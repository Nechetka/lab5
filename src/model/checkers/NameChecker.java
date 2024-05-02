package model.checkers;

import exceptions.NotSupportedValueException;

public class ChapterNameChecker implements Checked<String>{
    @Override
    public boolean check(String obj) {
        return (obj != null && !obj.trim().isEmpty());
    }
}
