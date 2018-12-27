package com.atgenee

class User {

    String username
    String remark

    static constraints = {

    }

    static mapping = {
        version false
    }

    User(String username, String remark) {
        this.username = username
        this.remark = remark
    }


    @Override
    String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
