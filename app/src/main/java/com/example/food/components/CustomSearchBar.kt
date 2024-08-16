package com.example.food.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    placeholderColor: Color = MaterialTheme.colorScheme.onSecondary,
    onClick: ()->Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    background: Color = MaterialTheme.colorScheme.background,
    searchContainerColor:Color = MaterialTheme.colorScheme.tertiaryContainer,
    searchTextColors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedTextColor = MaterialTheme.colorScheme.onTertiary,
        unfocusedTextColor = MaterialTheme.colorScheme.onTertiary,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent)) {

    Box(modifier = modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 10.dp)
        .background(background)) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(searchContainerColor)
            .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            if (leadingIcon != null) {
                Box(modifier = Modifier.padding(start = 16.dp),
                    contentAlignment = Alignment.Center) {
                    leadingIcon()
                }
            }

            Box(modifier = Modifier
                .weight(1f)
                .clickable { onClick() }) {
                TextField(
                    value = query,
                    onValueChange = { onQueryChange(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = searchTextColors,
                    placeholder = {
                        Text(text = hint, style = MaterialTheme.typography.bodyLarge,
                            color = placeholderColor)
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { onSearch() })
                )
            }
        }
    }
}

/*@Composable
fun CustomSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    var status = remember { mutableStateOf(false) }

    Box(modifier = modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 10.dp)
        .background(MaterialTheme.colorScheme.background)) {

        if (status.value) {
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .clickable { status.value = !status.value },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    if (leadingIcon != null) {
                        Box(modifier = Modifier.padding(start = 16.dp),
                            contentAlignment = Alignment.Center) {
                            leadingIcon()
                        }
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .clickable { status.value = !status.value }) {
                        TextField(
                            value = query,
                            onValueChange = onQueryChange,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedTextColor = MaterialTheme.colorScheme.onTertiary,
                                unfocusedTextColor = MaterialTheme.colorScheme.onTertiary,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            placeholder = {
                                Text(
                                    text = hint,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSecondary
                                )
                            },
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = { onSearch()
                                status.value = !status.value})
                        )
                    }
                }
                content()
            }

        } else {
            // Стандартный вид SearchBar
            Row(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .clickable { status.value = !status.value },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {

                if (leadingIcon != null) {
                    Box(
                        modifier = Modifier.padding(start = 16.dp),
                        contentAlignment = Alignment.Center) {
                        leadingIcon()
                    }
                }

                Box(modifier = Modifier
                    .weight(1f)
                    .clickable { status.value = !status.value }) {
                    TextField(
                        value = query,
                        onValueChange = {
                            onQueryChange(it)
                            status.value = !status.value
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedTextColor = MaterialTheme.colorScheme.onTertiary,
                            unfocusedTextColor = MaterialTheme.colorScheme.onTertiary,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = {
                            Text(text = hint,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(onSearch = { onSearch() })
                    )
                }
            }
        }
    }
}
*/
