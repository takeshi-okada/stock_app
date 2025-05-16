<script setup lang="ts">
import { ref, reactive } from 'vue'
import axios from 'axios'
import { useCustomToast } from '../config/ToastConfig.ts';
import { stockService } from '../services/StockService';

const toast = useCustomToast();
defineProps<{ msg: string }>()

const inputTicker = ref('');
const stockPrice = ref('');
const comparedToThePreviousDay = ref('');
const percentComparedToThePreviousDay = ref('');

const handleSearchTicker = async () => {
    stockService(inputTicker.value).then(result => {
        console.log(result.data);
        stockPrice.value = result.data.stockPrice
        comparedToThePreviousDay.value = result.data.comparedToThePreviousDay
        percentComparedToThePreviousDay.value = result.data.percentComparedToThePreviousDay
    }).catch(err => {
        toast.showErrorToast(err);
        console.log(err);
    });
}

</script>

<template>
  <h1 class="text-3xl font-bold underline">
    Dashboad
  </h1>
  <hr>

  <div class="mb-4">
        <label for="ticker" class="block text-sm font-medium text-gray-700">株</label>
        <input
            type="text"
            id="ticker"
            v-model="inputTicker"
            name="ticker"
            required
            class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
        />
        <button v-on:click= "handleSearchTicker" class="w-full bg-sky-500 text-white py-2 px-4 rounded-md shadow hover:bg-sky-600">
                検索
        </button>
    </div>
    <div>株価： {{ stockPrice }}</div>
    <div>前日比： {{ comparedToThePreviousDay }}</div>
    <div>前日比パーセント： {{ percentComparedToThePreviousDay }}%</div>
</template>

<style scoped>

</style>
