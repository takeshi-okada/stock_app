<script setup lang="ts">
import { useCustomToast } from '../config/ToastConfig.ts';
import Sidebar from '../components/Sidebar.vue';

const toast = useCustomToast();
toast.showSuccessToast("ログイン成功");



</script>

<template>
    <Sidebar />
</template>

<style scoped>

</style>
