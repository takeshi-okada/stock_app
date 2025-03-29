/**
 * 半角英数字チェック
 * @param target 対象文字列 
 * @returns true: 対象文字列は半角英数字 false: 対象文字列は半角英数字ではない
 */
export const checkHalfWidthAlphanumericCharacter = (target: string): boolean => {
    if (!target.match(/^[A-Za-z0-9]*$/)) {
        return false;
    }
    return true;     
}