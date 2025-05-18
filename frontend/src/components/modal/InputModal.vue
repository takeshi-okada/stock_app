<script setup lang="ts">
import { defineEmits } from 'vue';
import { MODE } from '../../constant/constants';

const props = defineProps<{ mode: string, formDefs: any, formData: any }>();
const emit = defineEmits(['clickClose']);

const title = props.mode === MODE.NEW ? "新規登録" : "編集"
const buttonName = props.mode === MODE.NEW ? "登録" : "更新"

/** 閉じるボタン押下時処理 */
const clickClose = () => {
    emit('clickClose');
}

/** 新規登録処理 */
const clickRegister = () => {
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
                <template v-for="formDef in formDefs" :key="formDef.field">
                    <template v-if="formDef.hasElements">
                        <div class="mb-4">
                            <h3>{{ formDef.label }}</h3>
                            <template v-for="element in formDef.elements" :key="element.field">
                                <div class="ml-4">
                                    <label :for="element.field" class="text-sm font-medium text-gray-700">{{ element.label }}</label>
                                    <input
                                        type="text"
                                        :id="element.field"
                                        :name="element.field"
                                        v-model="formData[element.field]"
                                        :disabled="element.disabled"
                                        required
                                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                                    />
                                </div>
                            </template>
                        </div>
                    </template>
                    <template v-else>
                        <div class="mb-4">
                            <label :for="formDef.field" class="text-sm font-medium text-gray-700">{{ formDef.label }}</label>
                            <input
                                type="text"
                                :id="formDef.field"
                                :name="formDef.field"
                                v-model="formData[formDef.field]"
                                required
                                :disabled="formDef.disabled"
                                class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm"
                            />
                        </div>
                    </template>
                </template>
                <button type="submit" class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600">
                    {{ buttonName }}
                </button>
                <button type="button" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600" v-on:click="clickClose">
                    閉じる
                </button>
            </form>
        </div>
    </div>
</template>

<style scoped>

</style>
