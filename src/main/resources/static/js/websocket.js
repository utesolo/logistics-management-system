$(document).ready(function() {
    // WebSocket URL
    const wsUrl = 'ws://127.0.0.1:9001/websocket/message';

    // 创建 WebSocket 连接
    const socket = new WebSocket(wsUrl);

    let mySessionId; // 用于存储当前客户端的sessionId

    // 监听连接打开事件
    socket.addEventListener('open', function(event) {
        console.log('WebSocket connection opened:', event);
        // 获取当前客户端的sessionId
        mySessionId = socket.url.split('/').pop();
    });

    // 监听消息接收事件
    socket.addEventListener('message', function(event) {
        console.log('Received message:', event.data);
        // 解析消息格式
        const messageData = JSON.parse(event.data);
        const senderId = messageData.senderId;
        const messageText = messageData.message;

        let messageElement;
        if (senderId === mySessionId) {
            // 自己发送的消息
            messageElement = $('<div>', {class: 'right-message'})
                .append($('<span>', {class: 'sender-id'}).text(senderId))
                .append($('<p>', {class: 'message-text'}).text(messageText));
        } else {
            // 其他用户发送的消息
            messageElement = $('<div>', {class: 'left-message'})
                .append($('<span>', {class: 'sender-id'}).text(senderId))
                .append($('<p>', {class: 'message-text'}).text(messageText));
        }

        $('#messages').append(messageElement);
        // 自动滚动到底部
        $('#messages').scrollTop($('#messages')[0].scrollHeight);
    });

    // 监听连接关闭事件
    socket.addEventListener('close', function(event) {
        console.log('WebSocket connection closed:', event);
    });

    // 监听错误事件
    socket.addEventListener('error', function(event) {
        console.error('WebSocket error:', event);
    });

    // 发送按钮点击事件
    $('#send-button').click(function() {
        const message = $('#message-input').val();
        if (message.trim() !== '') {
            // 构建消息对象
            const messageData = {
                senderId: mySessionId,
                message: message.replace("你", "我").replace("吗", "")
            };
            socket.send(JSON.stringify(messageData));
            $('#message-input').val('');
        }
    });

    // 按下回车键发送消息
    $('#message-input').keypress(function(event) {
        if (event.which === 13) { // Enter key
            $('#send-button').click();
        }
    });
});