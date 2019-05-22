package com.ssos.formengine.controller;

import com.ssos.base.model.DateResult;
import com.ssos.formengine.dto.AutoDefinitionDTO;
import com.ssos.formengine.dto.UpdateDefinitionDTO;
import com.ssos.formengine.service.SysDefinitionService;
import com.ssos.formengine.vo.FieldVO;
import com.ssos.formengine.vo.SysDefinitionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName: SysDefinitionAllController
 * @Description: 后台设置跟
 * @Author: xwl
 * @Date: 2019-05-21 15:08
 * @Vsersion: 1.0
 */
@RestController
@RequestMapping("/SysDefinition")
@Api(tags = "后台设置定义、动态创建表")
public class SysDefinitionController {

    @Autowired
    private SysDefinitionService sysDefinitionService;

    @ApiOperation("查询定义表列表（无子表）")
    @GetMapping("/findAll")
    public DateResult<List<SysDefinitionVO>> findAll() {
        return DateResult.ok(sysDefinitionService.SysDefinition());
    }

    @ApiOperation("根据id获取field字段列表")
    @GetMapping("/findFieldById")
    public DateResult<List<FieldVO>> findFieldById(@RequestParam Long id) {
        return DateResult.ok(sysDefinitionService.findFieldById(id));
    }

    @ApiOperation("定义添加以及动态创建表")
    @PostMapping("/addDefinition")
    public DateResult add(@RequestBody AutoDefinitionDTO autoDefinitionDTO) {
        sysDefinitionService.add(autoDefinitionDTO);
        return DateResult.ok();
    }

    @ApiOperation("定义修改以及动态修改表结构")
    @PostMapping("/updateDefinition")
    public DateResult update(@RequestBody @Valid UpdateDefinitionDTO updateDefinitionDTO) {
        sysDefinitionService.sysUpdateDefinition(updateDefinitionDTO);
        return DateResult.ok();
    }
}