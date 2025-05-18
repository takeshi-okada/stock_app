<script setup lang="ts">
import { defineEmits, ref, reactive } from 'vue';
import { MODE } from '../../constant/constants';

const props = defineProps<{ mode: string }>();
const emit = defineEmits(['clickClose']);
const title = props.mode === MODE.NEW ? "新規登録" : "編集"
const buttonName = props.mode === MODE.NEW ? "登録" : "更新"

/** 入力銘柄コード */
const inputTicker = ref('');
/** 特定(一般)口座 */
const taxableBrokerageAccount = reactive({
    /** 保有株数 */
    inputSharesHeld: 0,
    /** 平均取得単価 */
    inputAveragePurchasePrice: 0,
});
/** 旧NISA口座 */
const oldNisaAccount = reactive({
    /** 保有株数 */
    inputSharesHeld: 0,
    /** 平均取得単価 */
    inputAveragePurchasePrice: 0,
});
/** 新NISA口座(成長投資枠) */
const newNisaGrowthAccount = reactive({
    /** 保有株数 */
    inputSharesHeld: 0,
    /** 平均取得単価 */
    inputAveragePurchasePrice: 0,
})
/** 新NISA口座(つみたて投資枠) */
const newNisaRegularInvestmentAccount = reactive({
    /** 保有株数 */
    inputSharesHeld: 0,
    /** 平均取得単価 */
    inputAveragePurchasePrice: 0,
})

/** 閉じるボタン押下時処理 */
const clickClose = () => {
    emit('clickClose');
}

/** 新規登録処理 */
const clickRegister = () => {
    console.log('新規登録');
    emit('clickClose');
}

</script>

<template>
    <!-- オーバーレイ -->
    <div id="overlay" class="fixed flex inset-0 bg-black/50 z-50 items-center justify-center">
        <!-- モーダル -->
        <div id="modal" class="bg-white p-6 rounded-lg shadow-lg max-w-3xl w-full h-[80vh] overflow-y-auto">
            <h2 class="text-2xl font-bold mb-6 text-center text-gray-800">{{ title }}</h2>
            <form @submit.prevent="clickRegister">
                <div class="mb-4">
                    <label for="ticker" class="text-sm font-medium text-gray-700">銘柄コード</label>
                    <input
                        type="text"
                        id="ticker"
                        name="ticker"
                        v-model="inputTicker"
                        required
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <h3>特定(一般)口座</h3>
                <div class="mb-4 ml-4">
                    <label for="shares-held" class="text-sm font-medium text-gray-700">保有株数</label>
                    <input
                        type="text"
                        id="shares-held"
                        name="sharesHeld"
                        v-model="taxableBrokerageAccount.inputSharesHeld"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <div class="mb-4 ml-4">
                    <label for="average-purchase-price" class="text-sm font-medium text-gray-700">平均取得単価</label>
                    <input
                        type="text"
                        id="average-purchase-price"
                        name="averagePurchasePrice"
                        v-model="taxableBrokerageAccount.inputAveragePurchasePrice"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <h3>旧NISA口座</h3>
                <div class="mb-4 ml-4">
                    <label for="shares-held" class="text-sm font-medium text-gray-700">保有株数</label>
                    <input
                        type="text"
                        id="shares-held"
                        name="sharesHeld"
                        v-model="oldNisaAccount.inputSharesHeld"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <div class="mb-4 ml-4">
                    <label for="average-purchase-price" class="text-sm font-medium text-gray-700">平均取得単価</label>
                    <input
                        type="text"
                        id="average-purchase-price"
                        name="averagePurchasePrice"
                        v-model="oldNisaAccount.inputAveragePurchasePrice"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <h3>新NISA口座(成長投資枠)</h3>
                <div class="mb-4 ml-4">
                    <label for="shares-held" class="text-sm font-medium text-gray-700">保有株数</label>
                    <input
                        type="text"
                        id="shares-held"
                        name="sharesHeld"
                        v-model="newNisaGrowthAccount.inputSharesHeld"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <div class="mb-4 ml-4">
                    <label for="average-purchase-price" class="text-sm font-medium text-gray-700">平均取得単価</label>
                    <input
                        type="text"
                        id="average-purchase-price"
                        name="averagePurchasePrice"
                        v-model="newNisaGrowthAccount.inputAveragePurchasePrice"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <h3>新NISA口座(つみたて投資枠)</h3>
                <div class="mb-4 ml-4">
                    <label for="shares-held" class="text-sm font-medium text-gray-700">保有株数</label>
                    <input
                        type="text"
                        id="shares-held"
                        name="sharesHeld"
                        v-model="newNisaRegularInvestmentAccount.inputSharesHeld"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <div class="mb-4 ml-4">
                    <label for="average-purchase-price" class="text-sm font-medium text-gray-700">平均取得単価</label>
                    <input
                        type="text"
                        id="average-purchase-price"
                        name="averagePurchasePrice"
                        v-model="newNisaRegularInvestmentAccount.inputAveragePurchasePrice"
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                    />
                </div>
                <button type="submit" class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600">
                    {{ buttonName }}
                </button>
                <button class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600" v-on:click="clickClose">
                    閉じる
                </button>
            </form>
        </div>
    </div>
</template>

<style scoped>

</style>
