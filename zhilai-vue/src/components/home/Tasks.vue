<template>
  <div>
    <TaskCard v-for="taskInfo in tasks" :key="taskInfo" :taskInfo="taskInfo"></TaskCard>
  </div>
</template>
<script>
import TaskCard from "./TaskCard";
export default {
  name: "Tasks",
  components: {
    TaskCard
  },
  data() {
    return {
      tasks: [
        {
          title: "测试标题",
          author: "刘正星",
          currentDate: new Date(),
          infos:
            "需要设置visible属性，它接收Boolean，当为true时显示 Dialog。Dialog 分为两个部分：body和footer，footer需要具名为footer的slot。title属性用于定义标题，它是可选的，默认值为空。最后，本例还展示了before-close的用法。"
        },
        {
          title: "测试标题",
          author: "刘正星",
          currentDate: new Date(),
          infos:
            "需要设置visible属性，它接收Boolean，当为true时显示 Dialog。Dialog 分为两个部分：body和footer，footer需要具名为footer的slot。title属性用于定义标题，它是可选的，默认值为空。最后，本例还展示了before-close的用法。"
        },
        {
          title: "测试标题",
          author: "刘正星",
          currentDate: new Date(),
          infos:
            "需要设置visible属性，它接收Boolean，当为true时显示 Dialog。Dialog 分为两个部分：body和footer，footer需要具名为footer的slot。title属性用于定义标题，它是可选的，默认值为空。最后，本例还展示了before-close的用法。"
        }
      ]
    };
  }
};
</script>

<style  scoped lang="">
</style>
