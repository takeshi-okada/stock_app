<script setup lang="ts">
import { useCustomToast } from '../config/ToastConfig.ts';
import Sidebar from '../components/Sidebar.vue';
import Main from '../components/Main.vue';


const toast = useCustomToast();
toast.showSuccessToast("ログイン成功");



</script>

<template>
    <div class="flex min-h-screen">
        <Sidebar />
        <Main />
    </div>
</template>

<style scoped>

</style>
