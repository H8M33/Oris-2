package api;

import dto.request.ChatRequest;
import dto.response.ChatResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Api (tags = "Chats | ����", value = "���")
@RequestMapping("/chats")
public interface ChatApi {

    @ApiOperation(value = "�������� ����", nickname = "chat-create", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��� ������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PostMapping({"/{userId}"})
    @ResponseStatus(HttpStatus.CREATED)
    void createChat(@PathVariable UUID userId, @RequestBody ChatRequest request);

    @ApiOperation(value = "���������� ������������ � ���", nickname = "add-user-to-chat", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������������ ��������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PutMapping("/{chatId}/add/{userId}")
    @ResponseStatus(HttpStatus.OK)
    void addUser(@PathVariable UUID userId, @PathVariable UUID chatId);

    @ApiOperation(value = "���������� ����", nickname = "chat-update", response = ChatResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��� �������", response = ChatResponse.class),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PutMapping("/{chatId}/update")
    @ResponseStatus(HttpStatus.OK)
    ChatResponse updateChat(@PathVariable UUID chatId, @RequestBody ChatRequest request);

    @ApiOperation(value = "�������� ����", nickname = "chat-delete", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��� �����"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @DeleteMapping("/{chatId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteChatById(@PathVariable UUID chatId);

    @ApiOperation(value = "����� ��� �� ����", nickname = "chat-get-by-id", response = ChatResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��� ������", response = ChatResponse.class),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/{chatId}")
    @ResponseStatus(HttpStatus.OK)
    ChatResponse getChatById(@PathVariable UUID chatId);

    @ApiOperation(value = "��������� ���� ����� ������������", nickname = "chat-list-get-by-user-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ ���������", response = List.class),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    List<ChatResponse> getChatsByUserId(@PathVariable UUID userId);

    @ApiOperation(value = "�������� ������ ���� �����", nickname = "chat-list-get", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ ���������", response = List.class),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ChatResponse> getChats();

    @ApiOperation(value = "��������� ���� ������", nickname = "chat-get-by-group-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��� �������", response = List.class),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/group/{groupId}")
    @ResponseStatus(HttpStatus.OK)
    ChatResponse getChatByGroupId (@PathVariable UUID groupId);

}
