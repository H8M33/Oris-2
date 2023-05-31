package api;

import dto.request.PostRequest;
import dto.response.PostResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Posts | �����", value = "����")
@RequestMapping("/posts")
public interface PostApi {

    @ApiOperation(value = "�������� ����� �� ����� ������������", nickname = "post-create", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "���� ������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PostMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createPostByUser(@PathVariable UUID userId,@RequestBody PostRequest request);

    @ApiOperation(value = "�������� ����� �� ����� ������", nickname = "post-create", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "���� ������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PostMapping("/group/{groupId}/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    void createPostByGroup(@PathVariable UUID groupId, @PathVariable UUID userId, @RequestBody PostRequest request);

    @ApiOperation(value = "���������� �����", nickname = "post-update", response = PostResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "���� �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    PostResponse updatePost(@PathVariable UUID postId, @RequestBody PostRequest request);

    @ApiOperation(value = "�������� �����", nickname = "post-delete", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "���� �����"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    void deletePostById(@PathVariable UUID postId);

    @ApiOperation(value = "��������� �����", nickname = "post-get-by-id", response = PostResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "���� �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    PostResponse getPostById(@PathVariable UUID postId);

    @ApiOperation(value = "��������� ������ ���� ������", nickname = "post-get-all", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ ���� ������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PostResponse> getPosts();

    @ApiOperation(value = "��������� ������ ������ �� ���� ������-������������",
            nickname = "post-get-by-user-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    List<PostResponse> getPostsByUserId(@PathVariable UUID userId);

    @ApiOperation(value = "��������� ������ ������ �� ���� ������-������",
            nickname = "post-get-by-group-id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������ �������"),
            @ApiResponse(code = 400, message = "������ ���������")})
    @GetMapping("/group/{groupId}")
    @ResponseStatus(HttpStatus.OK)
    List<PostResponse> getPostsByGroupId(@PathVariable UUID groupId);
}
