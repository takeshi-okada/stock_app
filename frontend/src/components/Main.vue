<script setup lang="ts">



</script>

<template>
    <div class="flex-1 p-6 bg-gray-100">
        <div class="sm:hidden">
            <button id="hamburger" class="text-gray-600 p-2 rounded-md focus:outline-none">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="w-6 h-6">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path>
                </svg>
            </button>
        </div>
        <div>
            <router-view />
        </div>
    </div>
</template>

<style scoped>

</style>