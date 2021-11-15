FROM node
COPY app /root/app
RUN cd /root/app; git init
RUN npm install @commitlint/cli @commitlint/config-conventional --save-dev
RUN echo "module.exports = {extends: ['@commitlint/config-conventional']}" > commitlint.config.js
RUN npm install husky --save-dev
RUN npx husky install
RUN npm set-script prepare "husky install"
RUN npx husky add .husky/commit-msg 'npx --no -- commitlint --edit "$1"'
RUN npm i --save-dev standard-version




