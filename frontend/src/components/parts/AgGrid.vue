<script setup lang="ts">
import type {
  ColDef,
  GridApi,
  GridOptions,
  GridReadyEvent,
} from 'ag-grid-community';
import { ref } from 'vue';


const emit = defineEmits(['rowSelected']);

/**
 * Props定義
 */
const props = defineProps<{
    /** カラム定義 */
    columnDefs: ColDef[];
    /** 表示データ */
    rowData: any[];
    /** その他オプション */
    gridOptions?: GridOptions;
    /** 高さ */
    height?: string;
    /** 幅 */
    width?: string;
}>();

// API用のref
const gridApi = ref<GridApi | null>(null)

/**
 * デフォルト高さ・幅
 */
const height = props.height ?? '40vh';
const width = props.width ?? '100%';

const onGridReady = (event: GridReadyEvent) => {
  gridApi.value = event.api
}
const onSelectionChanged = () => {
  const selectedRows = gridApi.value?.getSelectedRows() || []
  emit('rowSelected', selectedRows)
}

</script>

<template>
  <div :style="{ height, width }">
    <ag-grid-vue
        style="width: 100%; height: 100%"
        :columnDefs="columnDefs"
        :rowData="rowData"
        :gridOptions="gridOptions"
        @grid-ready="onGridReady"
        @selection-changed="onSelectionChanged"
    >
    </ag-grid-vue>
  </div>
</template>

<style scoped>

</style>
