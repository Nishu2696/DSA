class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rect1X1 = rec1[0];
        int rect1Y1 = rec1[1];
        int rect1X2 = rec1[2];
        int rect1Y2 = rec1[3];

        int rect2X1 = rec2[0];
        int rect2Y1 = rec2[1];
        int rect2X2 = rec2[2];
        int rect2Y2 = rec2[3];

        if (rect1X1 == rect1X2 || rect1Y1 == rect1Y2 || rect2X1 == rect2X2 || rect2Y1 == rect2Y2) {
            return false;
        }

        return !((rect1X2 <= rect2X1) || (rect1Y2 <= rect2Y1) || (rect1X1 >= rect2X2) || (rect1Y1 >= rect2Y2));
    }
}