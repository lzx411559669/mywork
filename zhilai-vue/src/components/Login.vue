<template>
  <div class="bg">
    <!-- <el-button @click="show3 = !show3">{{activeName}}</el-button> -->
    <h1>职 来</h1>

    <el-form
      v-model="ruleForm"
      status-icon
      :rules="rules"
      ref="ruleForm"
      label-width="50px"
      class="demo-ruleForm"
    >
      <el-collapse-transition appear>
      <el-tabs v-model="activeName" @tab-click="handleClick;show3 = activeName" >
        <el-tab-pane label="登陆" name="login">
        
            <div v-show="show3===activeName" class="card">
              <el-form-item label="账号" prop="username" >
                <el-input class="input" type="text" v-model="ruleForm.username" value="admin" placeholder="admin"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="pass" >
                <el-input
                  class="input"
                  type="password"
                  v-model="ruleForm.password"
                  autocomplete="off"
                  placeholder="123456"
                ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="login">登陆</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </div>
      
        </el-tab-pane>
        <el-tab-pane label="注册" name="register">
            
          <div v-show="show3===activeName" class="card" >
            <!-- 注册组件 -->
            <Register></Register>
          </div>
          
        </el-tab-pane>
      </el-tabs>
       </el-collapse-transition>
    </el-form>
     
  </div>
</template>
<script>
import Register from "./Register";
export default {
  name: "Login",
  components: {
    Register
  },
  data() {
    return {
      activeName: "login",
      show3: "login",
      ruleForm: {
        username: "",
        password: ""
      },
      responseResult: []
    };
  },
  methods: {
    login() {
      this.$axios
        .post("/login", {
          username: this.ruleForm.username,
          password: this.ruleForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {});
    },
    resetForm(formName) {
      //this.$refs[formName].resetFields();
      this.ruleForm.username = "";
      this.ruleForm.password = "";
    }
  }
};
</script>
<style>
h1{
  margin-top: 70px;
  font-size: 50px;
  font-weight: 200;
}
.demo-ruleForm {
  /* position: absolute;
  top: 20%;
  left: 38%; */
  border-radius: 15px;
  background-clip: padding-box;
  margin: 100px auto;
  width: 400px;
  padding: 25px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.card {
  margin-top: 20px;
}
.bg{
  position: absolute;
  top: 0;
  left: 0;
  margin: 0;
  width: 100%;
  height: 960px;
  background: url(https://static.zhihu.com/heifetz/assets/sign_bg.db29b0fb.png) no-repeat center;
  background-size: cover;
  


}
html{
  margin: 0;
  padding: 0;
}
</style>