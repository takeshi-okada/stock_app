
/**
 * 動的にメッセージを出力する
 * @param message 出力するメッセージ 
 * @param args 動的に変換するパラメータ
 * @returns メッセージ
 */
export const getMessage = (message: string, ...args: string[]) => {

    const result = args.reduce((accumulator, currentValue, currentIndex) => {
        return accumulator.replace("{" + currentIndex + "}", currentValue)
    }, message);

    return result;
}