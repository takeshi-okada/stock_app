import { useToast } from 'vue-toast-notification';

// トーストのカスタム設定をまとめた関数
export const useCustomToast = () => {
  const toast = useToast();

  const showSuccessToast = (message: string) => {
    toast.success(message, {
      position: 'top-right',
      duration: 4000,
      dismissible: true,
      pauseOnHover: true,
    });
  };

  const showErrorToast = (message: string) => {
    toast.error(message, {
      position: 'top-right',
      duration: 0,
      dismissible: true,
      pauseOnHover: true,
    });
  };

  const showWarningToast = (message: string) => {
    toast.warning(message, {
      position: 'top-right',
      duration: 0,
      dismissible: true,
      pauseOnHover: true,
    });
  };

  const showInfoToast = (message: string) => {
    toast.info(message, {
      position: 'top-right',
      duration: 3000,
      dismissible: true,
      pauseOnHover: true,
    });
  };

  return {
    showSuccessToast,
    showErrorToast,
    showWarningToast,
    showInfoToast,
  };
};