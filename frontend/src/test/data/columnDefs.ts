export const columnDefs = [
    { field: 'date', headerName: '年-月', sortable: true, filter: true },
    {
        headerName: '自分',
        children: [
            { field: 'bank_1', headerName: '三井住友銀行', sortable: true, filter: true, headerStyle: { backgroundColor: '#cfa' } },
            { field: 'bank_2', headerName: '楽天銀行', sortable: true, filter: true, headerStyle: { backgroundColor: '#fba' } },
            { field: 'stock_1', headerName: '楽天証券', sortable: true, filter: true, headerStyle: { backgroundColor: '#fac'} },
            { field: 'total_1', headerName: '合計1', sortable: true, filter: true },
            { field: 'diff_1', headerName: '差額1', sortable: true, filter: true },
        ],
        headerStyle: { backgroundColor: '#dcf' },
    },
    {
        headerName: '共有',
        children: [
            { field: 'bank_3', headerName: '共有三井住友', sortable: true, filter: true, headerStyle: { backgroundColor: '#afb' } },
            { field: 'bank_4', headerName: 'ゆうちょ', sortable: true, filter: true, headerStyle: { backgroundColor: '#afe' } },
            { field: 'total_2', headerName: '合計2', sortable: true, filter: true },
            { field: 'diff_2', headerName: '差額2', sortable: true, filter: true },
        ],
        headerStyle: { backgroundColor: '#fed' },
    },
    {
        headerName: '退職後',
        children: [
            { field: 'pension_1', headerName: 'IDECO', sortable: true, filter: true, headerStyle: { backgroundColor: '#fda' } },
            { field: 'pension_2', headerName: '小規模企業共済', sortable: true, filter: true, headerStyle: { backgroundColor: '#acf' } },
            { field: 'pension_3', headerName: '変額保険', sortable: true, filter: true, headerStyle: { backgroundColor: '#ffa' } },
            { field: 'pension_4', headerName: '個人年金', sortable: true, filter: true, headerStyle: { backgroundColor: '#eaf' } },
            { field: 'total_3', headerName: '合計3', sortable: true, filter: true },
            { field: 'diff_3', headerName: '差額3', sortable: true, filter: true },
        ],
        headerStyle: { backgroundColor: '#cfd' },
    }
]