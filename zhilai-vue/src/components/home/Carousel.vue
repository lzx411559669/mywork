<template>
  <el-carousel :interval="4000" type="card" height="450px">
    <el-carousel-item v-for="item in 4" :key="item">
      <h1>广告位出租{{item}}</h1>
    </el-carousel-item>
  </el-carousel>
</template>
<script>
export default {
    name:"Carousel",
    data(){
        return{
            imgList:[
                
            ]
        }
    }
}
</script>
<style>
.el-carousel{
    margin-top: 20px;
}
  .el-carousel__item img {
    max-width: 100%;  
    max-height: 100%;  
    
    
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>