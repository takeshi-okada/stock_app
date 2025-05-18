<script setup lang="ts">
import { reactive, ref } from 'vue'

import InputModal from './modal/InputModal.vue';
import { MODE } from '../constant/constants';

/** 登録モーダル開閉フラグ */
const openModalFlg = ref(false);

/** モード */
const mode = ref(MODE.NEW);

const formDefs = [
  {
    field: 'ticker',
    label: '銘柄コード',
    disabled: true,
    hasElements: false,
  },
  {
    field: 'taxableBrokerageAccount',
    label: '特定(一般)口座',
    hasElements: true,
    elements: [
      {
        field: 'taxableBrokerageAccountSharesHeld',
        label: '保有株数',
        disabled: false,
      },
      {
        field: 'taxableBrokerageAccountAveragePurchasePrice',
        label: '平均取得単価',
        disabled: false,
      },
    ]
  },
  {
    field: 'oldNisaAccount',
    label: '旧NISA口座',
    hasElements: true,
    elements: [
      {
        field: 'oldNisaAccountSharesHeld',
        label: '保有株数',
        disabled: false,
      },
      {
        field: 'oldNisaAccountAveragePurchasePrice',
        label: '平均取得単価',
        disabled: false,
      },
    ]
  },
  {
    field: 'newNisaGrowthAccount',
    label: '新NISA口座(成長投資枠)',
    hasElements: true,
    elements: [
      {
        field: 'newNisaGrowthAccountSharesHeld',
        label: '保有株数',
        disabled: false,
      },
      {
        field: 'newNisaGrowthAccountAveragePurchasePrice',
        label: '平均取得単価',
        disabled: false,
      },
    ]
  },
  {
    field: 'newNisaRegularInvestmentAccount',
    label: '新NISA口座(つみたて投資枠)',
    hasElements: true,
    elements: [
      {
        field: 'newNisaRegularInvestmentAccountSharesHeld',
        label: '保有株数',
        disabled: false,
      },
      {
        field: 'newNisaRegularInvestmentAccountAveragePurchasePrice',
        label: '平均取得単価',
        disabled: false,
      },
    ]
  },
];

const formData = reactive({
  ticker: '',
  taxableBrokerageAccountSharesHeld: '',
  taxableBrokerageAccountAveragePurchasePrice: '',
  oldNisaAccountSharesHeld: '',
  oldNisaAccountAveragePurchasePrice: '',
  newNisaGrowthAccountSharesHeld: '',
  newNisaGrowthAccountAveragePurchasePrice: '',
  newNisaRegularInvestmentAccountSharesHeld: '',
  newNisaRegularInvestmentAccountAveragePurchasePrice: '',
});

/**
 * 資産追加登録ボタン押下時処理
 */
const clickOpenRegisterModal = () => {
  mode.value = MODE.NEW;
  openModalFlg.value = true;
}

/**
 * 編集ボタン押下時処理
 */
const clickOpenEditModal = () => {
  mode.value = MODE.EDIT;
  openModalFlg.value = true;
}

/**
 * 登録モーダル閉じるボタン押下後処理
 */
const handleClose = () => {
  openModalFlg.value = false;
}

</script>

<template>
  <h1 class="mb-4 text-3xl font-bold underline">
    配当管理
  </h1>
  <div>
    <button v-on:click="clickOpenRegisterModal">銘柄追加登録</button>
    <button v-on:click="clickOpenEditModal">編集</button>
  </div>
  <div v-if="openModalFlg">
    <InputModal
      :mode="mode"
      :formDefs="formDefs"
      :formData="formData"
      @click-close="handleClose"
    />
  </div>
</template>

<style scoped>

</style>
