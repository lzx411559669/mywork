<template>
    <!-- 布局 -->
      <el-container>
        <!-- 头部 -->
  <el-header>  
    <div class="logo">zhi lai</div>
    <Menu></Menu>
  </el-header>
  <!-- 走马灯 -->
   <Carousel></Carousel>
    <el-container>
    <el-aside width="25%">广告位出租
      <img src="@/assets/gg.png" alt="">
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
    <el-aside width="25%">广告位出租</el-aside>
  </el-container>
  <el-footer>Footer</el-footer>
</el-container>

   
</template>

<script>
import Menu from "./Menu"
import Carousel from "./Carousel"
  export default {
    name: 'AppIndex',
    components:{
       Menu,
       Carousel
    },
    data(){
      return{
       
      }
    }
  }
</script>

<style scoped>
.el-header{
  /* border-bottom: 1px solid rgb(152, 155, 153); */
  
 
}
.el-header, .el-footer { 
    display: flex;   
    color: #333;
    text-align: center;
    line-height: 60px;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,.06);
  }
   .el-main {
    background-color: #E9EEF3;
    color: #333;  
    padding: 0;
    margin: 0 10px;
    
  }
  .logo{
    /* margin-left: 200px; */
    font-size: 25px;
    font-weight: 700;
  }
    .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    /* line-height: 200px; */
  }
 .el-footer{
   margin-top: 20px;
   border: solid 0.5px silver;
 }
 .el-aside img{
   max-width: 100%;
   max-height: 100%;
 }
 
</style>
