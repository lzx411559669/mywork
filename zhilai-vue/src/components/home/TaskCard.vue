<template>
  <el-card :body-style="{ padding: '0px' }" shadow="hover">
    
    <div style="padding: 5px;">
      <h1>{{taskInfo.title}}</h1>
      <p>{{taskInfo.infos}}</p>
      <div class="bottom clearfix">
        <time class="time">{{ taskInfo.currentDate }}</time>
        <el-button type="text" class="button" @click="dialogVisible = true">点击详情</el-button>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="50%" :before-close="handleClose">
          <span>这是一段信息</span>
           <h1>{{taskInfo.title}}</h1>
           <p>{{taskInfo.infos}}</p>
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
        </el-dialog>
      </div>
    </div>
  </el-card>
</template>
<script>
export default {
  name: "TaskCard",
  props:{
    taskInfo:Object
  },
  data() {
    return {
        dialogVisible: false,
     
    };
  },
   methods: {
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    }
};
</script>
<style scoped>
.el-card{
  /* height: 400px; */
  margin: 0;
}
</style>