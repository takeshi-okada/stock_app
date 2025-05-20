<script setup lang="ts">
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
} from 'chart.js';

import { Bar } from 'vue-chartjs';


ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

/**
 * Props定義
 */
const props = defineProps<{ chartData: any }>();

const chartOptions:any = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
        legend: {
            position: 'top',
        },
        title: {
            display: true,
            text: '月別資産グラフ'
        },
    },
    scales: {
        x: {
            stacked: true, // X軸の積み上げ
        },
        y: {
            stacked: true, // Y軸の積み上げ
        },
    }
}
</script>

<template>
    <!-- 横スクロールを許可するラッパー -->
    <div class="overflow-x-auto">
        <!-- 横幅を固定（例: 1500px） -->
        <div class="min-w-[400px] lg:min-w-[700px] h-1/1">
            <Bar :data="props.chartData" :options="chartOptions" />
        </div>
    </div>
</template>
