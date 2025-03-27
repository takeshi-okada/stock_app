<script setup lang="ts">
import { ref, reactive } from 'vue'

</script>

<template>
 <div class="bg-gray-100 min-h-screen flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-lg w-96">
        <h2 class="text-2xl font-bold mb-6 text-center text-gray-800">新規ユーザ登録</h2>
        <form action="#" method="POST">
            <div class="mb-4">
                <label for="user-name" class="text-sm font-medium text-gray-700">ユーザー名</label>
                <input
                    type="text"
                    id="user-name"
                    name="userName"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                />
            </div>
            <div class="mb-6">
                <label for="password" class="block text-sm font-medium text-gray-700">パスワード</label>
                <input
                    type="password"
                    id="password"
                    name="password"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm" 
                />
            </div>
            <div class="mb-6">
                <label for="password-second" class="block text-sm font-medium text-gray-700">確認用パスワード</label>
                <input
                    type="password"
                    id="password-second"
                    name="passwordSecond"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm" 
                />
            </div>
            <div class="mb-6">
                <label for="birth" class="block text-sm font-medium text-gray-700">生年月日</label>
                <input
                    type="date"
                    id="birth"
                    name="birth"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm" 
                />
            </div>
            <button type="submit" class="w-full bg-sky-500 text-white py-2 px-4 rounded-md shadow hover:bg-sky-600">
                新規登録
            </button>
        </form>
        <router-link to="/" class="block text-sm text-right mt-4">
            ログイン画面に戻る
        </router-link>
    </div>
 </div> 
</template>

<style scoped>

</style>
