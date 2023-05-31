package api;

import dto.request.MessageRequest;
import dto.response.MessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Messages | ���������", value = "���������")
@RequestMapping("/messages")
public interface MessageApi {

    @ApiOperation(value = "�������� ���������", nickname = "message-create", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��������� �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PostMapping("/chat/{chatId}/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createMessage(@PathVariable UUID userId, @PathVariable UUID chatId, @RequestBody MessageRequest request);

    @ApiOperation(value = "���������� ���������", nickname = "message-update", response = MessageResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��������� ���������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PutMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    MessageResponse updateMessage(@PathVariable UUID messageId, @RequestBody MessageRequest request);

    @ApiOperation(value = "�������� ���������", nickname = "message-delete", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��������� �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @DeleteMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteMessageById(@PathVariable UUID messageId);

    @ApiOperation(value = "��������� ��������� �� ����", nickname = "message-get-by-id", response = MessageResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��������� ��������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    MessageResponse getMessageById(@PathVariable UUID messageId);

    @ApiOperation(value = "��������� ������ ���� ���������", nickname = "message-get-list", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<MessageResponse> getMessages();

    @ApiOperation(value = "��������� ������ ��������� �� ���� ������-������������",
            nickname = "message-get-list-by-user-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    List<MessageResponse> getMessagesByUserId(@PathVariable UUID userId);

    @ApiOperation(value = "��������� ������ ���� ��������� �� ���� ����",
            nickname = "message-get-list-by-chat-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/chat/{chatId}")
    @ResponseStatus(HttpStatus.OK)
    List<MessageResponse> getMessagesByChatId(@PathVariable UUID chatId);

    @ApiOperation(value = "��������� ������ ���� ��������� �� ���� ���� � ���� ������������",
            nickname = "message-get-list-by-chat-id-and-user-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/chat/{chatId}/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    List<MessageResponse> getMessagesByChatIdAndUserId(@PathVariable UUID chatId, @PathVariable UUID userId);

}
