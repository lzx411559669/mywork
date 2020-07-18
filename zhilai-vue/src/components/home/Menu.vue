<template>
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    text-color="#000"
    active-text-color="#ffd04b"
  >
    <el-menu-item index="1">
      <router-link to="/index/tasks">大厅</router-link>
    </el-menu-item>
    <el-menu-item index="3">帮助</el-menu-item>
    <el-menu-item index="4">反馈</el-menu-item>
    <el-menu-item class="avatar">
      <div @click="drawer = true">
        <el-avatar :src="img"></el-avatar>
      </div>
     <el-drawer title="个人中心" :visible.sync="drawer" :with-header="false">
        <el-card class="box-card">
          <el-avatar :src="img"></el-avatar>
          <div class="nickname">刘正星</div>
          <el-collapse v-model="activeNames" @change="handleChange">
            <el-collapse-item title="个人信息" name="1" class="personInfo">
              <div>年龄：{{personInfo.age}}</div>
              <div>性别：{{personInfo.sex}}</div>
              <div>个性签名：{{personInfo.signature}}</div>
            </el-collapse-item>
            <el-collapse-item title="我的订单" name="2">
              <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
              <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
            </el-collapse-item>
            <el-collapse-item title="我的需求" name="3">
              <div>简化流程：设计简洁直观的操作流程；</div>
              <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
              <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
            </el-collapse-item>
            <el-collapse-item title="个人空间" name="4">
              <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
              <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-drawer>
      

    </el-menu-item>
  </el-menu>
</template>
<script>
export default {
  name:"Menu",
 
  data() {
    return {
      drawer: false,
      img: require("@/assets/head.jpg"),
      activeNames: ['1'],
      personInfo:{
        nickname:"刘正星",
        age:22,
        sex:"男",
        signature:"除了帅一无所有"

      }
    };
  }
};
</script>

<style scoped>
button {
  border-radius: 50%;
}
.avatar {
  position: absolute;
  right: 20px;
}
.el-menu-demo {
  /* padding-left: 600px; */
  width: 70%;
  margin: 0 auto;
}
</style>