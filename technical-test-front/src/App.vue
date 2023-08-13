<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <person-line />
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import PersonLine from './components/PersonLine.vue';

export default defineComponent({
  components:{
    PersonLine
  }
})
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
