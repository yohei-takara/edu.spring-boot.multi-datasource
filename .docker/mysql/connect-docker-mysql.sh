#! /bin/bash
set -Ceu


echo -e "chose login user." \
        "root "

read user

case "${user}" in
  root)
    mysql -uroot \
          -proot \
          --port=13306 \
          --host=127.0.0.1
    ;;
  *)
    echo "Don't exist user."
    ;;
esac
