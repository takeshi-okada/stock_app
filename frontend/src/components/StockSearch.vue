<script setup lang="ts">
import { reactive, ref } from 'vue'

import { useCustomToast } from '../config/ToastConfig.ts';
import { stockService } from '../services/StockService.ts';
import Loading from './parts/Loading.vue';

const toast = useCustomToast();

/** 銘柄コード入力値 */
const inputTicker = ref('');
/** 画面表示値 */
const displayValue = reactive({
    /** 銘柄名 */
    companyName: 'XXXX',
    /** 銘柄コード */
    ticker: 'xxxx',
    /** セクター */
    sector: '-',
    /** 株価 */
    stockPrice: '-,---',
    /** 前日比 */
    comparedToThePreviousDay: '-',
    /** 前日比パーセント */
    percentComparedToThePreviousDay: '-',
    /** 前日終値 */
    yesterdayFinishPrice: '',
    /** 始値 */
    startPrice: '',
    /** 高値 */
    highestPrice: '',
    /** 安値 */
    lowestPrice: '',
    /** 一株あたり配当金（会社予想） */
    dps: '',
    /** 配当利回り（会社予想） */
    dividendYield: '',
    /** 配当性向 */
    dividendPayoutRatio: '',
    /** 基準月 */
    baseMonth: '',
    /** 第一四半期 */
    firstQuarter: '',
    /** 第二四半期 */
    secondQuarter: '',
    /** 第三四半期 */
    thirdQuarter: '',
    /** 第四四半期 */
    fourthQuarter: '',
})

/** ローディング中フラグ */
const isLoading = ref(false);

const handleSearchTicker = async () => {
    isLoading.value = true;
    stockService(inputTicker.value).then(result => {
        displayValue.companyName = result.data.tickerData.companyName;
        displayValue.ticker = result.data.tickerData.ticker;
        displayValue.sector = result.data.tickerData.sector;
        displayValue.stockPrice = result.data.tickerData.stockPrice;
        displayValue.comparedToThePreviousDay = result.data.tickerData.comparedToThePreviousDay;
        displayValue.percentComparedToThePreviousDay = result.data.tickerData.percentComparedToThePreviousDay;
        displayValue.yesterdayFinishPrice = result.data.tickerData.startPrice;
        displayValue.startPrice = result.data.tickerData.highestPrice;
        displayValue.highestPrice = result.data.tickerData.highestPrice;
        displayValue.lowestPrice = result.data.tickerData.lowestPrice;
        displayValue.dps = result.data.dividendData.dps;
        displayValue.dividendYield = result.data.dividendData.dividendYield;
        displayValue.dividendPayoutRatio = result.data.dividendData.dividendPayoutRatio;
        displayValue.baseMonth = result.data.dividendData.baseMonth;
        displayValue.firstQuarter = result.data.dividendData.firstQuarter;
        displayValue.secondQuarter = result.data.dividendData.secondQuarter;
        displayValue.thirdQuarter = result.data.dividendData.thirdQuarter;
        displayValue.fourthQuarter = result.data.dividendData.fourthQuarter;
    }).catch(err => {
        toast.showErrorToast(err.response.data.message);
        console.log(err);
    }).finally(() => {
        isLoading.value = false;
    });
}

</script>

<template>
    <div class="grid grid-cols-12 gap-4">
        <div class="col-span-6 text-2xl md:text-3xl font-bold">
            株検索
        </div>
        <input
            class="h-10 col-span-3 col-start-1 px-4 py-1 border border-gray-300 rounded-md shadow-sm"
            type="text"
            id="ticker"
            v-model="inputTicker"
            name="ticker"
            required
        />
        <button
            class="h-10 w-20 col-span-2 col-start-4 bg-blue-500 text-white px-4 py-1 rounded hover:bg-blue-600"
            v-on:click= "handleSearchTicker"
        >
            検索
        </button>
        <div class="col-span-10 lg:col-span-6 col-start-1 lg:col-start-1 p-4 grid grid-cols-12 gap-2 bg-white shadow-md rounded-lg">
            <div class="col-span-6 col-start-1 text-xs lg:text-xl">{{ `${displayValue.ticker} ${displayValue.sector}` }}</div>
            <div class="col-span-8 col-start-1 text-2xl lg:text-3xl">{{ displayValue.companyName }}</div>
            <div class="col-span-5 col-start-1 text-3xl lg:text-4xl font-bold">{{ displayValue.stockPrice }}</div>
            <div class="col-span-7 col-start-6 h-10 w-max py-2 px-2 text-xs grid place-items-center bg-blue-500 text-white rounded-2xl">前日比： {{ displayValue.comparedToThePreviousDay }} ({{ displayValue.percentComparedToThePreviousDay }}%)</div>
        </div>
        <div class="col-span-10 lg:col-span-6 col-start-1 lg:col-start-7 p-4 grid grid-cols-12 gap-2 bg-white shadow-md rounded-lg">
            <div class="col-span-12 col-start-1 text-xl lg:text-2xl">株価・株式情報</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">昨日終値</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.yesterdayFinishPrice}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">始値</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.startPrice}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">高値</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.highestPrice}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">安値</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.lowestPrice}}</div>
        </div>
        <div class="col-span-10 lg:col-span-6 col-start-1 lg:col-start-1 p-4 grid grid-cols-12 gap-2 bg-white shadow-md rounded-lg">
            <div class="col-span-12 col-start-1 text-xl lg:text-2xl">配当情報</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">一株あたり配当金</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.dps}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">配当利回り</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.dividendYield}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">配当性向</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.dividendPayoutRatio}}</div>
        </div>
        <div class="col-span-10 lg:col-span-6 col-start-1 lg:col-start-7 p-4 grid grid-cols-12 gap-2 bg-white shadow-md rounded-lg">
            <div class="col-span-12 col-start-1 text-xl lg:text-2xl">配当支払月</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">基準月</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.baseMonth}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">第1四半期</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.firstQuarter}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">第2四半期</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.secondQuarter}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">第3四半期</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.thirdQuarter}}</div>
            <div class="col-span-6 lg:col-span-7 col-start-1 text-sm lg:text-xl">第4四半期</div>
            <div class="col-span-6 lg:col-span-5 text-sm lg:text-xl">{{displayValue.fourthQuarter}}</div>
        </div>
    </div>
    <Loading v-if="isLoading" />
</template>

<style scoped>

</style>
