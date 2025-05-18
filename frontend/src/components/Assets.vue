<script setup lang="ts">
import { reactive, ref } from 'vue'

import InputModal from './modal/InputModal.vue';
import { MODE } from '../constant/constants';
import AgGrid from './parts/AgGrid.vue';
import { columnDefs } from '../test/data/columnDefs';
import { rowData } from '../test/data/rowData';

/** 登録モーダル開閉フラグ */
const openModalFlg = ref(false);

/** モード */
const mode = ref(MODE.NEW);

const selectedRowDate = ref([]);

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
  if(selectedRowDate.value.length === 0) return

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
  openModalFlg.value = false;
}

/**
 * チェックボタン押下後処理
 */
const handleSelected = (rowData: any) => {
  selectedRowDate.value = rowData;
}

const myColumnDefs = columnDefs;
const myRowData = rowData;
const gridOptions = {
  rowSelection: {
    mode: 'singleRow' as const,
    checkboxes: true,
  }
}
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


</script>

<template>
  <h1 class="mb-4 text-3xl font-bold underline">
    資産
  </h1>
  <div>
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
</template>

<style scoped>

</style>
