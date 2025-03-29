<script setup lang="ts">
import { ref, reactive } from 'vue';
import { useCustomToast } from '../config/ToastConfig.ts';


const toast = useCustomToast();
toast.showWarningToast("ログイン成功");
</script>

<template>
    <div>ホーム画面</div>
</template>

<style scoped>

</style>
