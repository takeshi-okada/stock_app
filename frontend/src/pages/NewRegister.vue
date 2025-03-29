<script setup lang="ts">
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router';
import { useCustomToast } from '../config/ToastConfig';
import { ERR_COMMON_MESSAGE_01, ERR_COMMON_MESSAGE_02 } from '../constant/messageConstants';
import { checkHalfWidthAlphanumericCharacter } from '../utils/Validation';
import { getMessage } from '../utils/Message';

const router = useRouter();
const toast = useCustomToast()
const inputUserId = ref('');
const inputUserName = ref('');
const inputUserPassword = ref('');
const inputUserPasswordSecond = ref('');
const inputUserBirth = ref('');

const handleRegister = async () => {
    if (!checkHalfWidthAlphanumericCharacter(inputUserId.value)) {
        toast.showErrorToast(getMessage(ERR_COMMON_MESSAGE_02, "ユーザーID"));
        return
    }
    if (!checkHalfWidthAlphanumericCharacter(inputUserPassword.value)) {
        toast.showErrorToast(getMessage(ERR_COMMON_MESSAGE_02, "パスワード"));
        return
    }
    if (!checkHalfWidthAlphanumericCharacter(inputUserPasswordSecond.value)) {
        toast.showErrorToast(getMessage(ERR_COMMON_MESSAGE_02, "確認用パスワード"));
        return
    }
    if (inputUserPassword.value !== inputUserPasswordSecond.value) {
        toast.showErrorToast(getMessage(ERR_COMMON_MESSAGE_01, "パスワード", "確認用パスワード"));
        return
    }
    const param = {
        userId: inputUserId.value,
        userPassword: inputUserPassword.value,
    }
    toast.showSuccessToast("登録成功")
}
</script>

<template>
 <div class="bg-gray-100 min-h-screen flex items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-lg w-96">
        <h2 class="text-2xl font-bold mb-6 text-center text-gray-800">新規ユーザ登録</h2>
        <form @submit.prevent="handleRegister">
            <div class="mb-4">
                <label for="user-id" class="text-sm font-medium text-gray-700">ユーザーID (半角英数字)</label>
                <input
                    type="text"
                    id="user-id"
                    name="userId"
                    v-model="inputUserId"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                />
            </div>
            <div class="mb-4">
                <label for="user-name" class="text-sm font-medium text-gray-700">ユーザー名</label>
                <input
                    type="text"
                    id="user-name"
                    name="userName"
                    v-model="inputUserName"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                />
            </div>
            <div class="mb-6">
                <label for="password" class="block text-sm font-medium text-gray-700">パスワード (半角英数字)</label>
                <input
                    type="password"
                    id="password"
                    name="password"
                    v-model="inputUserPassword"
                    required
                    class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm" 
                />
            </div>
            <div class="mb-6">
                <label for="password-second" class="block text-sm font-medium text-gray-700">確認用パスワード (半角英数字)</label>
                <input
                    type="password"
                    id="password-second"
                    name="passwordSecond"
                    v-model="inputUserPasswordSecond"
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
                    v-model="inputUserBirth"
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
