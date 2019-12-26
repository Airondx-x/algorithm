//文字描述很麻烦，直接看题目图
//求n条垂线中，组成面积最大的这个面积

public class a11_maxArea {
    public int maxArea(int[] height) {
        int i=0,j= height.length-1;
        int maxarea = 0;
//        两指针相遇
        while(i<j){
            maxarea = Math.max(Math.min(height[i],height[j])*(j-i),maxarea);
//            移动y轴较短的指针
            if(height[i]>height[j])j--;
            else i++;
        }
        return maxarea;
    }
    public static void main(String[] args) {
        a11_maxArea a11 = new a11_maxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(a11.maxArea(height));
    }
}
