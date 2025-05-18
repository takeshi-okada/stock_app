<script setup lang="ts">
import { ref } from 'vue'

import { useCustomToast } from '../config/ToastConfig.ts';
import { stockService } from '../services/StockService.ts';

const toast = useCustomToast();

const inputTicker = ref('');
const companyName = ref('');
const ticker = ref('');
const sector = ref('');
const stockPrice = ref('');
const comparedToThePreviousDay = ref('');
const percentComparedToThePreviousDay = ref('');
const yesterdayFinishPrice = ref('');
const startPrice = ref('');
const highestPrice = ref('');
const lowestPrice = ref('');
const dps = ref('');
const dividendYield = ref('');
const dividendPayoutRatio = ref('');
const baseMonth = ref('');
const firstQuarter = ref('');
const secondQuarter = ref('');
const thirdQuarter = ref('');
const fourthQuarter = ref('');

const handleSearchTicker = async () => {
    stockService(inputTicker.value).then(result => {
        companyName.value = result.data.tickerData.companyName;
        ticker.value = result.data.tickerData.ticker;
        sector.value = result.data.tickerData.sector;
        stockPrice.value = result.data.tickerData.stockPrice;
        comparedToThePreviousDay.value = result.data.tickerData.comparedToThePreviousDay;
        percentComparedToThePreviousDay.value = result.data.tickerData.percentComparedToThePreviousDay;
        yesterdayFinishPrice.value = result.data.tickerData.startPrice;
        startPrice.value = result.data.tickerData.highestPrice;
        highestPrice.value = result.data.tickerData.highestPrice;
        lowestPrice.value = result.data.tickerData.lowestPrice;
        dps.value = result.data.dividendData.dps;
        dividendYield.value = result.data.dividendData.dividendYield;
        dividendPayoutRatio.value = result.data.dividendData.dividendPayoutRatio;
        baseMonth.value = result.data.dividendData.baseMonth;
        firstQuarter.value = result.data.dividendData.firstQuarter;
        secondQuarter.value = result.data.dividendData.secondQuarter;
        thirdQuarter.value = result.data.dividendData.thirdQuarter;
        fourthQuarter.value = result.data.dividendData.fourthQuarter;
    }).catch(err => {
        toast.showErrorToast(err.response.data.message);
        console.log(err);
    });
}

</script>

<template>
  <h1 class="text-3xl font-bold underline">
    株検索
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
        <button v-on:click= "handleSearchTicker" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
                検索
        </button>
    </div>
    <div>{{ companyName }}</div>
    <div>{{ ticker }}: {{ sector }}</div>
    <div>株価： {{ stockPrice }}</div>
    <div>前日比： {{ comparedToThePreviousDay }}</div>
    <div>前日比パーセント： {{ percentComparedToThePreviousDay }}%</div>
    <div>前日終値： {{ yesterdayFinishPrice }}</div>
    <div>始値： {{ startPrice }}</div>
    <div>高値： {{ highestPrice }}</div>
    <div>安値： {{ lowestPrice }}</div>
    <div>一株あたり配当金（会社予想）： {{ dps }}</div>
    <div>配当利回り（会社予想）： {{ dividendYield }}</div>
    <div>配当性向： {{ dividendPayoutRatio }}</div>
    <div>基準月： {{ baseMonth }}</div>
    <div>第一四半期： {{ firstQuarter }}</div>
    <div>第二四半期： {{ secondQuarter }}</div>
    <div>第三四半期： {{ thirdQuarter }}</div>
    <div>第四四半期： {{ fourthQuarter }}</div>
</template>

<style scoped>

</style>
