FROM ubuntu:22.04

# ユーザ設定
ARG USERNAME=cozy
ARG USER_GROUP_NAME=developer
ARG USER_UID=1000
ARG USER_GID=1000

ARG PKG="git vim curl unzip zip sudo wget"

# シェル設定
SHELL ["/bin/bash", "-c"]

# 必要なパッケージをインストールし、ユーザーを作成
RUN apt-get update \
    && apt-get install -y ${PKG} \
    && groupadd --gid ${USER_GID} ${USER_GROUP_NAME} \
    && useradd --uid ${USER_UID} --shell /bin/bash --gid ${USER_GID} -m ${USERNAME} \
    && echo %${USER_GROUP_NAME} ALL=\(ALL\) NOPASSWD:ALL > /etc/sudoers.d/${USER_GROUP_NAME} \
    && chmod 0440 /etc/sudoers.d/${USER_GROUP_NAME}

# OpenJDK21とGradleをインストール
RUN apt-get install -y openjdk-21-jdk \
    && wget https://services.gradle.org/distributions/gradle-8.7-bin.zip \
    && unzip gradle-8.7-bin.zip -d /opt/gradle

# Gradleの環境変数を設定
RUN echo "export GRADLE_HOME=/opt/gradle/gradle-8.7" >> /home/${USERNAME}/.bashrc \
    && echo "export PATH=\$GRADLE_HOME/bin:\$PATH" >> /home/${USERNAME}/.bashrc \
    && chown ${USER_UID}:${USER_GID} /home/${USERNAME}/.bashrc

# 作成したユーザーをデフォルトユーザーとして設定
USER ${USERNAME}

# 作業ディレクトリを指定
CMD ["bash"]
