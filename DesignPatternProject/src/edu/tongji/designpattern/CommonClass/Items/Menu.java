package edu.tongji.designpattern.CommonClass.Items;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static Menu instance = new Menu();

    public static Menu getInstance() {
        return instance;
    }

    private List<Item> menuList=new ArrayList<>();

    String[] foodName = {"生菜沙拉", "番茄沙拉", "黄瓜沙拉", "鱼刺身", "虾刺身",
                         "鱼寿司", "黄瓜寿司", "黄瓜鱼寿司", "番茄意面","肉意面","蘑菇意面","鱼虾意面",
                         "油炸鸡","油炸土豆","油炸土豆鸡","肉卷饼","蘑菇卷饼","鸡肉卷饼",
                         "肉汉堡","芝士汉堡","青菜芝士汉堡", "青菜番茄汉堡", "菠萝肉汉堡",
                         "芝士披萨", "芝士香肠披萨", "芝士鸡披萨", "鸡蛋煎饼", "巧克力煎饼","鸡蛋草莓煎饼",
                         "蜂蜜蛋糕", "巧克力蛋糕", "蜂蜜胡萝卜蛋糕", "蒸鱼", "蒸肉", "蒸胡萝卜", "蒸虾",
                         "香蕉奶昔", "草莓奶昔", "西瓜奶昔", "波罗奶昔", "香蕉波罗奶昔", "烤鸡肉",
                         "烤肉", "烤蘑菇", "烤蘑菇菠萝", "可乐", "雪碧", "百威啤酒", "酸梅汁"};

    //对应上面的食物名称
    double[] foodPrice = {
            12, 13, 12, 22, 24,
            27, 25, 25, 22, 24, 26, 28,
            27, 25, 25, 22, 24, 26,
            28,27, 25, 25, 22,
            24, 26, 28,27, 25, 25,
            22, 24, 26, 28,27, 25, 15,
            22, 24, 26, 28,27, 25,
            25, 22, 24, 5, 6, 12, 5};

    //初始化菜单，向里面添加菜
    private Menu() {
        for(int i=0; i<foodName.length; i++){
            //Item dish=new Item(foodName[i],(int)(5+Math.random()*10));
            Item dish = new Item(foodName[i], foodPrice[i]);
            menuList.add(dish);
        }
    }


    //下面是get和set方法
    public List<Item> getMenu() {
        return menuList;
    }

    //展示菜单内的菜和价格
    public void showMenu(){
        for(int i=0; i<foodName.length; i++){
            System.out.println("菜名是"+menuList.get(i).getName()+",价格是"+menuList.get(i).getPrice());
        }
    }

}