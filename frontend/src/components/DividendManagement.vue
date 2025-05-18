<script setup lang="ts">
import { ref } from 'vue'

import RegisterModal from './modal/RegisterModal.vue';
import { MODE } from '../constant/constants';

/** 登録モーダル開閉フラグ */
const openModalFlg = ref(false);

/** モード */
const mode = ref(MODE.NEW);

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
  <h1 class="text-3xl font-bold underline">
    配当管理
  </h1>
  <hr>
  <div>
    <button v-on:click="clickOpenRegisterModal">銘柄追加登録</button>
    <button v-on:click="clickOpenEditModal">編集</button>
  </div>
  <div v-if="openModalFlg">
    <RegisterModal @click-close="handleClose" :mode="mode"/>
  </div>
</template>

<style scoped>

</style>
