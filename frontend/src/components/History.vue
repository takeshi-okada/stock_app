<script setup lang="ts">
import { ref, reactive } from 'vue'
import axios from 'axios'

const url = 'http://localhost:8080/init'
defineProps<{ msg: string }>()

const data = reactive({
  response: "",
  keyWord: "",
});

const getData = async () => {
  let result = await axios.get(url);
  data.response = result.data;
};

</script>

<template>
  <h1>{{ msg }}</h1>
  <button @click="getData">Request</button>
  <h1 class="text-3xl font-bold underline">
    History
  </h1>
  <hr>
  <div>
    {{ data.response }}
  </div>
</template>

<style scoped>

</style>
