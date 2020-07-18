<template>
<!-- 这里router-link to="newcontact"会把路由导航到http://localhost:8080/#/newcontact   -->
    <router-link to="newcontact"><h1>{{ msg }}</h1></router-link>

</template>

<script>
export default {//ES6语法，用于输出到外部，这样就可以在其他文件内用import输入
  name: 'HelloWorld',
  data () {//由于是组件，data必须是个函数，这是ES6写法，data后面加括号相当于data: function () {}
    return {//记得return 不然接收不到数据
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
