package com.ttyc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StreamExam {

    private static List<User> users = Arrays.asList(
            User.of(1L, 1, "tom", 10, 800),
            User.of(2L, 3, "kim", 18, 500),
            User.of(3L, 2, "tim", 15, 600),
            User.of(4L, 2, "tam", 20, 900),
            User.of(5L, 3, "pom", 20, 400),
            User.of(6L, 1, "yom", 14, 700));

    public static void main(String[] args) {
        StreamExam exam = new StreamExam();
    }

    /**
     * 获取user集合中所有的id
     */
    public List<Long> mapId(List<User> users) {
        return null;
    }

    /**
     * List转Map，以user id为key， user对象本身为value
     */
    public Map<Long, User> convertToMap(List<User> users) {
        return null;
    }

    /**
     * List转Map，以user id为key， age 为value，并且age*10
     */
    public Map<Long, Integer> convertToAgeMap(List<User> users) {
        return null;
    }

    /**
     * 找出年龄大于18，且薪资大于1000的用户，如果没有使用Optional抛出一个异常RuntimeException
     */
    public User filter(List<User> users) {
        return null;
    }

    /**
     * 按用户年龄降序排序，如果年龄相同，按薪资升序排序
     */
    public List<User> sort() {
        return null;
    }

    /**
     * 以用户年龄分组
     * @return
     */
    public Map<Integer, User> groupBy() {
       return null;
    }

    /**
     * 以用户薪资是否大于500分组
     */
    public Map<Boolean, List<User>> groupBySalary() {
        return null;
    }

    //------------------- 附加题 -------------------

    /**
     * 给定url /producer/api/user/1 根据入参个数去除前缀
     * 如: num = 1,返回 /api/user/1, num = 2，返回 /user/1,
     */
    public String stripPrefix(int num) {
        return null;
    }

    /**
     * 有6个日志文件，名称如下
     * 20190101_01.log
     * 20190101_02.log
     * 20190101_03.log
     *
     * 20190102_01.log
     * 20190102_02.log
     *
     * 20190103_01.log
     *
     * 要求：初始化为Stream，并以日期分组输出为以下格式
     * 20190102----[20190102_01.log, 20190102_02.log]
     * 20190101----[20190101_01.log, 20190101_02.log, 20190101_03.log]
     * 20190103----[20190103_01.log]
     */
    public void prefixGroupBy() {

    }

    private static class User {

        private Long id;

        private Integer group;

        private String name;

        private Integer age;

        private Integer salary;

        public static User of(Long id, Integer group, String name, Integer age, Integer salary) {
            User r = new User();
            r.setId(id);
            r.setGroup(group);
            r.setName(name);
            r.setAge(age);
            r.setSalary(salary);
            return r;
        }

        public User() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getGroup() {
            return group;
        }

        public void setGroup(Integer group) {
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }
    }
}
