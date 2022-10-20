public enum Problems {
    DOESNT_START(1), BLOCKED_DOOR(2), BROKEN_GLASS(3), OIL_CHANGE(4), LIGHT_BULBS_CHANGE(5);
    private int problemNumber;
    Problems(int problemNumber){
        this.problemNumber = problemNumber;
    }

    public int getProblemNumber() {
        return problemNumber;
    }
}
