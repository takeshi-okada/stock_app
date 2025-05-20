<script setup lang="ts">
import { reactive, ref } from 'vue';
import { cloneDeep }from 'lodash';

import InputModal from './modal/InputModal.vue';
import { MODE } from '../constant/constants';
import AgGrid from './parts/AgGrid.vue';
import { columnDefs } from '../test/data/columnDefs';
import { rowData } from '../test/data/rowData';
import { _addColumnDefaultAndTypes } from 'ag-grid-community';
import { useCustomToast } from '../config/ToastConfig';
import { getMessage } from '../utils/Message';
import { ERR_COMMON_MESSAGE_03 } from '../constant/messageConstants';
import MonthlyBarChart from './parts/MonthlyBarChart.vue';
import { chartDefs } from '../test/data/chartDefs';

const toast = useCustomToast();

/** 登録モーダル開閉フラグ */
const openModalFlg = ref(false);
/** モード */
const mode = ref(MODE.NEW);
/** 選択行データ */
const selectedRowDate = ref([]);
/** カラム定義 */
const myColumnDefs = cloneDeep(columnDefs);
/** 行データ */
const myRowData = cloneDeep(rowData);
/** チャート定義 */
const myChartDefs = cloneDeep(chartDefs);
/** グリッドオプション */
const gridOptions = {
  rowSelection: {
    mode: 'singleRow' as const,
    checkboxes: true,
  }
};
/** フォーム定義 */
const formDefs = [
  {
    field: 'self',
    label: '自分',
    hasElements: true,
    elements: [
      {
        field: 'bank_1',
        label: '三井住友銀行',
      },
      {
        field: 'bank_2',
        label: '楽天銀行',
      },
      {
        field: 'stock_1',
        label: '楽天証券',
      },
    ]
  },
  {
    field: 'share',
    label: '共有',
    hasElements: true,
    elements: [
      {
        field: 'bank_3',
        label: '共有三井住友',
      },
      {
        field: 'bank_4',
        label: 'ゆうちょ',
      },
    ]
  },
  {
    field: 'retirement',
    label: '退職後',
    hasElements: true,
    elements: [
      {
        field: 'pension_1',
        label: 'IDECO',
      },
      {
        field: 'pension_2',
        label: '小規模企業共済',
      },
      {
        field: 'pension_3',
        label: '変額保険',
      },
      {
        field: 'pension_4',
        label: '個人年金',
      },
    ]
  },
];
/** フォームデータ */
const formData: {[key: string]: string} = reactive({
  bank_1: '',
  bank_2: '',
  stock_1: '',
  bank_3: '',
  bank_4: '',
  pension_1: '',
  pension_2: '',
  pension_3: '',
  pension_4: '',
});
const datasets = myChartDefs.map(def => ({
  label: def.label,
  data: myRowData.map(row => row[def.field as keyof typeof row]).slice(-10),
  backgroundColor: def.color,
}));
/** チャートデータ */
const chartData = {
  labels: myRowData.map(data => data.date).slice(-10),
  datasets: datasets
}

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
  if(selectedRowDate.value.length === 0) {
    toast.showErrorToast(getMessage(ERR_COMMON_MESSAGE_03, "編集画面"));
    return;
  }

  for (const data in selectedRowDate.value[0]) {
    formData[data] = selectedRowDate.value[0][data]
  }

  mode.value = MODE.EDIT;
  openModalFlg.value = true;
}

/**
 * 登録モーダル閉じるボタン押下後処理
 */
const handleClose = () => {
  // フォームデータを初期化
  for (const data in formData) {
    formData[data] = '';
  }
  openModalFlg.value = false;
}

/**
 * チェックボタン押下後処理
 */
const handleSelected = (rowData: any) => {
  selectedRowDate.value = rowData;
}

</script>

<template>
  <div class="grid grid-cols-12 gap-2 lg:gap-4 bg-gray-100">
    <h1 class="col-span-12 text-3xl font-bold">
      資産
    </h1>
    <MonthlyBarChart
      class="h-60 md:h-70 col-span-12"
      :chartData="chartData"
    />
    <div class="col-span-12">
      <button
        class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600"
        v-on:click="clickOpenRegisterModal"
      >
        資産追加登録
      </button>
      <button
        class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        v-on:click="clickOpenEditModal"
      >
        編集
      </button>
    </div>
    <AgGrid
      class="h-100 col-span-12"
      :columnDefs="myColumnDefs"
      :rowData="myRowData"
      :gridOptions="gridOptions"
      @rowSelected="handleSelected"
    />
    <div v-if="openModalFlg">
      <InputModal
        :mode="mode"
        :formDefs="formDefs"
        :formData="formData"
        @click-close="handleClose"
      />
    </div>
  </div>
</template>

<style scoped>

</style>
